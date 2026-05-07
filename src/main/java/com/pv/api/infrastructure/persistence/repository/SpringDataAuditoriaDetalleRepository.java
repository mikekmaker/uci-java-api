package com.pv.api.infrastructure.persistence.repository;

import com.pv.api.infrastructure.persistence.entity.AuditoriaDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataAuditoriaDetalleRepository
        extends JpaRepository<AuditoriaDetalleEntity, Long> {

    List<AuditoriaDetalleEntity> findByAuditoriaId(Long auditoriaId);
}