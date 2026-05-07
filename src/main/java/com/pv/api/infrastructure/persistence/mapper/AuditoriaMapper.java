package com.pv.api.infrastructure.persistence.mapper;

import com.pv.api.domain.model.AuditStatus;
import com.pv.api.domain.model.Auditoria;
import com.pv.api.infrastructure.persistence.entity.AuditoriaEntity;

public class AuditoriaMapper {

    private AuditoriaMapper() {}

    public static Auditoria toDomain(AuditoriaEntity entity) {

        if (entity == null) {
            return null;
        }

        return new Auditoria(
                entity.getId(),
                entity.getUserId(),
                entity.getCodigoFuente(),
                entity.getLenguaje(),
                entity.getCodigoExplicado(),
                entity.getReingenieria(),
                AuditStatus.valueOf(entity.getEstado()),
                entity.getErrorMensaje(),
                entity.getErrorDetalle(),
                entity.getTiempoEjecucion(),
                entity.getFechaCreacion(),
                entity.getFechaActualizacion(),
                AuditoriaDetalleMapper.toDomainList(entity.getDetalles())
        );
    }

    public static AuditoriaEntity toEntity(Auditoria domain) {

        if (domain == null) {
            return null;
        }

        AuditoriaEntity entity = new AuditoriaEntity();

        entity.setId(domain.getId());
        entity.setUserId(domain.getUserId());
        entity.setCodigoFuente(domain.getCodigoFuente());
        entity.setLenguaje(domain.getLenguaje());
        entity.setCodigoExplicado(domain.getCodigoExplicado());
        entity.setReingenieria(domain.getReingenieria());

        if (domain.getEstado() != null) {
            entity.setEstado(domain.getEstado().name());
        }

        entity.setErrorMensaje(domain.getErrorMensaje());
        entity.setErrorDetalle(domain.getErrorDetalle());
        entity.setTiempoEjecucion(domain.getTiempoEjecucion());
        entity.setFechaCreacion(domain.getFechaCreacion());
        entity.setFechaActualizacion(domain.getFechaActualizacion());

        entity.setDetalles(
                AuditoriaDetalleMapper.toEntityList(domain.getDetalles())
        );

        return entity;
    }
}