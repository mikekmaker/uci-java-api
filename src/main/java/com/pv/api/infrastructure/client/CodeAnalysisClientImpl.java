package com.pv.api.infrastructure.client;

import com.pv.api.domain.service.CodeAnalysisClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CodeAnalysisClientImpl
        implements CodeAnalysisClient {

    private final RestTemplate restTemplate;

    public CodeAnalysisClientImpl(
            RestTemplate restTemplate
    ) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String analyzeCode(
            String codigoFuente,
            String lenguaje,
            String tipoAnalisis
    ) {

        return "ANALISIS_PENDIENTE";
    }
}