package com.pv.api.infrastructure.persistence.repository;

import com.pv.api.infrastructure.persistence.entity.AuditoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataAuditoriaRepository
        extends JpaRepository<AuditoriaEntity, Long> {

    List<AuditoriaEntity> findByUserId(Long userId);

    Optional<AuditoriaEntity> findByIdAndUserId(Long id, Long userId);
}