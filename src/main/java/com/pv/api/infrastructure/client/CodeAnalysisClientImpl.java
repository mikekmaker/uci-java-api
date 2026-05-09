package com.pv.api.infrastructure.client;

import com.pv.api.domain.service.CodeAnalysisClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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
            String tipoAnalisis,
            String token
    ) {

        String url = "https://uci-py-api.onrender.com/analyze";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        Map<String, Object> body = new HashMap<>();
        body.put("code", codigoFuente);
        body.put("language", lenguaje);
        //body.put("tipoAnalisis", tipoAnalisis);

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        return restTemplate.postForObject(
                url,
                request,
                String.class
        );
    }
}