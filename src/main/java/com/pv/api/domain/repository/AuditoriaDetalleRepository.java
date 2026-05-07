package com.pv.api.domain.repository;


import com.pv.api.domain.model.AuditoriaDetalle;

import java.util.List;

public interface AuditoriaDetalleRepository {

    List<AuditoriaDetalle> saveAll(List<AuditoriaDetalle> detalles);

    List<AuditoriaDetalle> findByAuditoriaId(Long auditoriaId);

    void deleteByAuditoriaId(Long auditoriaId);
}