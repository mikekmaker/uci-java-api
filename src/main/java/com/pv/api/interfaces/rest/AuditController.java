package com.pv.api.interfaces.rest;

import com.pv.api.application.dto.AnalyzeAuditoriaRequest;
import com.pv.api.application.dto.AnalyzeAuditoriaResponse;
import com.pv.api.application.dto.ErrorResponse;
import com.pv.api.application.usecase.AnalyzeAuditoriaUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/audit")
public class AuditController {

    private final AnalyzeAuditoriaUseCase
            analyzeAuditoriaUseCase;

    public AuditController(
            AnalyzeAuditoriaUseCase analyzeAuditoriaUseCase
    ) {
        this.analyzeAuditoriaUseCase =
                analyzeAuditoriaUseCase;
    }

    @PostMapping("/analyze")
    public ResponseEntity<AnalyzeAuditoriaResponse> analyze(
            @RequestBody AnalyzeAuditoriaRequest request,
            Authentication authentication
    ) {
        System.out.println("ENTRO A AUDIT CONTROLLER");
        String username = authentication.getName();

        AnalyzeAuditoriaResponse response =
                analyzeAuditoriaUseCase.execute(
                        request,
                        username
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}