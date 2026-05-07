package com.pv.api.domain.repository;

import com.pv.api.domain.model.Auditoria;

import java.util.List;
import java.util.Optional;

public interface AuditoriaRepository {

    Auditoria save(Auditoria auditoria);

    Optional<Auditoria> findById(Long id);

    Optional<Auditoria> findByIdAndUserId(Long id, Long userId);

    List<Auditoria> findByUserId(Long userId);

    void deleteById(Long id);
}