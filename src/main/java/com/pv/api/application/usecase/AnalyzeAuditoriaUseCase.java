package com.pv.api.application.usecase;

import com.pv.api.application.dto.AnalyzeAuditoriaRequest;
import com.pv.api.application.dto.AnalyzeAuditoriaResponse;

public interface AnalyzeAuditoriaUseCase {

    AnalyzeAuditoriaResponse execute(
            AnalyzeAuditoriaRequest request,
            String username,
            String token
    );
}