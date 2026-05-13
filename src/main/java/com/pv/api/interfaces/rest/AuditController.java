package com.pv.api.interfaces.rest;

import com.pv.api.application.dto.AnalyzeAuditoriaRequest;
import com.pv.api.application.dto.AnalyzeAuditoriaResponse;
import com.pv.api.application.dto.ErrorResponse;
import com.pv.api.application.usecase.AnalyzeAuditoriaUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.pv.api.application.dto.AuditoriaHeaderResponse;
import com.pv.api.application.usecase.GetAuditoriaUseCase;

import java.util.List;

@RestController
@RequestMapping("/api/v1/audit")
public class AuditController {

    private final AnalyzeAuditoriaUseCase
            analyzeAuditoriaUseCase;

    private final GetAuditoriaUseCase
            getAuditoriaUseCase;

    public AuditController(
            AnalyzeAuditoriaUseCase analyzeAuditoriaUseCase,
            GetAuditoriaUseCase getAuditoriaUseCase
    ) {
        this.analyzeAuditoriaUseCase = analyzeAuditoriaUseCase;
        this.getAuditoriaUseCase = getAuditoriaUseCase;
    }

    @PostMapping("/analyze")
    public ResponseEntity<AnalyzeAuditoriaResponse> analyze(
            @RequestBody AnalyzeAuditoriaRequest request,
            Authentication authentication
    ) {
        System.out.println("ENTRO A AUDIT CONTROLLER");
        String username = authentication.getName();
        String token = (String) authentication.getCredentials();
        AnalyzeAuditoriaResponse response =
                analyzeAuditoriaUseCase.execute(
                        request,
                        username,
                        token
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/registro")
    public ResponseEntity<List<AuditoriaHeaderResponse>>
    getAll(
            Authentication authentication
    ) {

        String username =
                authentication.getName();

        List<AuditoriaHeaderResponse> response =
                getAuditoriaUseCase.getAll(
                        username
                );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/registro/{auditoriaId}")
    public ResponseEntity<AuditoriaHeaderResponse>
    getById(
            @PathVariable Long auditoriaId,
            Authentication authentication
    ) {

        String username =
                authentication.getName();

        AuditoriaHeaderResponse response =
                getAuditoriaUseCase.getById(
                        auditoriaId,
                        username
                );

        return ResponseEntity.ok(response);
    }
}