package com.pv.api.infrastructure.persistence;

import com.pv.api.domain.model.Auditoria;
import com.pv.api.domain.repository.AuditoriaRepository;
import com.pv.api.infrastructure.persistence.entity.AuditoriaEntity;
import com.pv.api.infrastructure.persistence.mapper.AuditoriaMapper;
import com.pv.api.infrastructure.persistence.repository.SpringDataAuditoriaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AuditoriaRepositoryImpl implements AuditoriaRepository {

    private final SpringDataAuditoriaRepository springDataAuditoriaRepository;

    public AuditoriaRepositoryImpl(
            SpringDataAuditoriaRepository springDataAuditoriaRepository
    ) {
        this.springDataAuditoriaRepository = springDataAuditoriaRepository;
    }

    @Override
    public Auditoria save(Auditoria auditoria) {

        AuditoriaEntity entity =
                AuditoriaMapper.toEntity(auditoria);

        AuditoriaEntity saved =
                springDataAuditoriaRepository.save(entity);

        return AuditoriaMapper.toDomain(saved);
    }

    @Override
    public Optional<Auditoria> findById(Long id) {

        return springDataAuditoriaRepository.findById(id)
                .map(AuditoriaMapper::toDomain);
    }

    @Override
    public Optional<Auditoria> findByIdAndUserId(Long id, Long userId) {

        return springDataAuditoriaRepository
                .findByIdAndUserId(id, userId)
                .map(AuditoriaMapper::toDomain);
    }

    @Override
    public List<Auditoria> findByUserId(Long userId) {

        return springDataAuditoriaRepository
                .findByUserId(userId)
                .stream()
                .map(AuditoriaMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {

        springDataAuditoriaRepository.deleteById(id);
    }
}