package com.pv.api.infrastructure.persistence.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pv.api.application.dto.CodeAnalysisResult;
import com.pv.api.domain.model.AuditoriaDetalle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CodeAnalysisMapper {

    private final ObjectMapper objectMapper;

    public CodeAnalysisMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public CodeAnalysisResult toResult(String json) {
        try {
            return objectMapper.readValue(json, CodeAnalysisResult.class);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing analysis result", e);
        }
    }

    public List<AuditoriaDetalle> toDetalles(CodeAnalysisResult result) {

        List<AuditoriaDetalle> detalles = new ArrayList<>();

        if (result.getIssues() == null) {
            return detalles;
        }

        for (var issue : result.getIssues()) {

            AuditoriaDetalle detalle = new AuditoriaDetalle();

            detalle.setSeverity(issue.getSeverity());
            detalle.setType(issue.getType());
            detalle.setDescription(issue.getDescription());
            detalle.setLine(issue.getLine());

            detalles.add(detalle);
        }

        return detalles;
    }
}
