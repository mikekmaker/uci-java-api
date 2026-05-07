package com.pv.api.infrastructure.persistence;

import com.pv.api.domain.model.AuditoriaDetalle;
import com.pv.api.domain.repository.AuditoriaDetalleRepository;
import com.pv.api.infrastructure.persistence.entity.AuditoriaDetalleEntity;
import com.pv.api.infrastructure.persistence.mapper.AuditoriaDetalleMapper;
import com.pv.api.infrastructure.persistence.repository.SpringDataAuditoriaDetalleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AuditoriaDetalleRepositoryImpl
        implements AuditoriaDetalleRepository {

    private final SpringDataAuditoriaDetalleRepository
            springDataAuditoriaDetalleRepository;

    public AuditoriaDetalleRepositoryImpl(
            SpringDataAuditoriaDetalleRepository
                    springDataAuditoriaDetalleRepository
    ) {
        this.springDataAuditoriaDetalleRepository =
                springDataAuditoriaDetalleRepository;
    }

    @Override
    public List<AuditoriaDetalle> saveAll(
            List<AuditoriaDetalle> detalles
    ) {

        List<AuditoriaDetalleEntity> entities =
                AuditoriaDetalleMapper.toEntityList(detalles);

        List<AuditoriaDetalleEntity> saved =
                springDataAuditoriaDetalleRepository.saveAll(entities);

        return AuditoriaDetalleMapper.toDomainList(saved);
    }

    @Override
    public List<AuditoriaDetalle> findByAuditoriaId(
            Long auditoriaId
    ) {

        return springDataAuditoriaDetalleRepository
                .findByAuditoriaId(auditoriaId)
                .stream()
                .map(AuditoriaDetalleMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByAuditoriaId(Long auditoriaId) {

        List<AuditoriaDetalleEntity> detalles =
                springDataAuditoriaDetalleRepository
                        .findByAuditoriaId(auditoriaId);

        springDataAuditoriaDetalleRepository.deleteAll(detalles);
    }
}