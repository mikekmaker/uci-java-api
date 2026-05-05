package com.pv.api.application.usecase;

import com.pv.api.application.dto.LoginRequest;
import com.pv.api.application.dto.LoginResponse;
import com.pv.api.domain.model.User;
import com.pv.api.domain.repository.UserRepository;
import com.pv.api.infrastructure.security.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoginUserUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginUserUseCase(UserRepository userRepository,
                            PasswordEncoder passwordEncoder,
                            JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public LoginResponse execute(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Credenciales invalidas"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Credenciales invalidas");
        }

        String token = jwtTokenProvider.generateToken(user.getUsername());

        return new LoginResponse(
                token,
                "bearer",
                jwtTokenProvider.getValidityInSeconds()
        );
    }
}