package com.pv.api.domain.service;

public interface CodeAnalysisClient {

    String analyzeCode(
            String codigoFuente,
            String lenguaje,
            String tipoAnalisis
    );
}