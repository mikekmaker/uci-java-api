package com.pv.api.infrastructure.persistence.mapper;

import com.pv.api.application.dto.AuditoriaDetalleResponse;
import com.pv.api.domain.model.AuditoriaDetalle;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class AuditoriaDetalleResponseMapper {

    public AuditoriaDetalleResponse toResponse(
            AuditoriaDetalle detalle
    ) {

        if (detalle == null) {
            return null;
        }

        AuditoriaDetalleResponse response =
                new AuditoriaDetalleResponse();

        response.setSeverity(detalle.getSeverity());
        response.setType(detalle.getType());
        response.setDescription(detalle.getDescription());
        response.setLine(detalle.getLine());

        return response;
    }

    public List<AuditoriaDetalleResponse> toResponseList(
            List<AuditoriaDetalle> detalles
    ) {

        if (detalles == null || detalles.isEmpty()) {
            return Collections.emptyList();
        }

        return detalles.stream()
                .map(this::toResponse)
                .toList();
    }
}