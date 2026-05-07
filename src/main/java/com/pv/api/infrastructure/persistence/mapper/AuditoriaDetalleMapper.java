package com.pv.api.infrastructure.persistence.mapper;

import com.pv.api.domain.model.AuditoriaDetalle;
import com.pv.api.infrastructure.persistence.entity.AuditoriaDetalleEntity;

import java.util.List;
import java.util.stream.Collectors;

public class AuditoriaDetalleMapper {

    private AuditoriaDetalleMapper() {}

    public static AuditoriaDetalle toDomain(AuditoriaDetalleEntity entity) {

        if (entity == null) {
            return null;
        }

        return new AuditoriaDetalle(
                entity.getId(),
                entity.getAuditoriaId(),
                entity.getSeverity(),
                entity.getType(),
                entity.getDescription(),
                entity.getLine()
        );
    }

    public static AuditoriaDetalleEntity toEntity(AuditoriaDetalle domain) {

        if (domain == null) {
            return null;
        }

        AuditoriaDetalleEntity entity = new AuditoriaDetalleEntity();

        entity.setId(domain.getId());
        entity.setAuditoriaId(domain.getAuditoriaId());
        entity.setSeverity(domain.getSeverity());
        entity.setType(domain.getType());
        entity.setDescription(domain.getDescription());
        entity.setLine(domain.getLine());

        return entity;
    }

    public static List<AuditoriaDetalle> toDomainList(
            List<AuditoriaDetalleEntity> entities
    ) {
        return entities.stream()
                .map(AuditoriaDetalleMapper::toDomain)
                .collect(Collectors.toList());
    }

    public static List<AuditoriaDetalleEntity> toEntityList(
            List<AuditoriaDetalle> domains
    ) {
        return domains.stream()
                .map(AuditoriaDetalleMapper::toEntity)
                .collect(Collectors.toList());
    }
}