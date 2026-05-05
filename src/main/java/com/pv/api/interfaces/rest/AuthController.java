package com.pv.api.interfaces.rest;

import com.pv.api.application.dto.*;
import com.pv.api.application.exception.UserAlreadyExistsException;
import com.pv.api.application.usecase.GetMeUseCase;
import com.pv.api.application.usecase.LoginUserUseCase;
import com.pv.api.application.usecase.RegisterUserUseCase;
import com.pv.api.infrastructure.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Parameter;
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final RegisterUserUseCase registerUserUseCase;
    private final LoginUserUseCase loginUserUseCase;

    private final JwtTokenProvider jwtTokenProvider;
    private final GetMeUseCase getMeUseCase;

    public AuthController(RegisterUserUseCase registerUserUseCase,
                          LoginUserUseCase loginUserUseCase,
                          JwtTokenProvider jwtTokenProvider,
                          GetMeUseCase getMeUseCase) {
        this.registerUserUseCase = registerUserUseCase;
        this.loginUserUseCase = loginUserUseCase;
        this.jwtTokenProvider = jwtTokenProvider;
        this.getMeUseCase = getMeUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(registerUserUseCase.execute(request));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserExists(UserAlreadyExistsException ex) {
        return ResponseEntity.status(409).body(new ErrorResponse(ex.getMessage()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            return ResponseEntity.ok(loginUserUseCase.execute(request));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(e.getMessage()));
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(
            @Parameter(description = "Bearer token", required = true)
            @RequestHeader("Authorization") String authHeader
    ) {

        try {
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return ResponseEntity.status(401)
                        .body(new ErrorResponse("Token invalido"));
            }

            String token = authHeader.substring(7);

            if (!jwtTokenProvider.validateToken(token)) {
                return ResponseEntity.status(401)
                        .body(new ErrorResponse("Token invalido"));
            }

            String username = jwtTokenProvider.getUsernameFromToken(token);

            return ResponseEntity.ok(getMeUseCase.execute(username));

        } catch (RuntimeException e) {
            return ResponseEntity.status(401)
                    .body(new ErrorResponse(e.getMessage()));
        }
    }

}
