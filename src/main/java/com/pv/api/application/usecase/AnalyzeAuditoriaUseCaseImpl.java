package com.pv.api.application.usecase;

import com.pv.api.application.dto.AnalyzeAuditoriaRequest;
import com.pv.api.application.usecase.AnalyzeAuditoriaUseCase;
import com.pv.api.application.dto.AnalyzeAuditoriaResponse;
import com.pv.api.domain.model.AuditStatus;
import com.pv.api.domain.model.Auditoria;
import com.pv.api.domain.model.User;
import com.pv.api.domain.repository.AuditoriaRepository;
import com.pv.api.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class AnalyzeAuditoriaUseCaseImpl
        implements AnalyzeAuditoriaUseCase {

    private final AuditoriaRepository auditoriaRepository;
    private final UserRepository userRepository;

    public AnalyzeAuditoriaUseCaseImpl(
            AuditoriaRepository auditoriaRepository,
            UserRepository userRepository
    ) {
        this.auditoriaRepository = auditoriaRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AnalyzeAuditoriaResponse execute(
            AnalyzeAuditoriaRequest request,
            String username
    ) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado")
                );

        Auditoria auditoria = new Auditoria();

        auditoria.setUserId(user.getUserId());

        auditoria.setCodigoFuente(request.getCodigoFuente());
        auditoria.setLenguaje(request.getLenguaje());

        auditoria.setEstado(AuditStatus.PROCESSING);

        auditoria.setFechaCreacion(LocalDateTime.now());
        auditoria.setFechaActualizacion(LocalDateTime.now());
        auditoria.setDetalles(new ArrayList<>());
        Auditoria saved =
                auditoriaRepository.save(auditoria);

        AnalyzeAuditoriaResponse response =
                new AnalyzeAuditoriaResponse();

        response.setAuditoriaId(saved.getId());
        response.setEstado(saved.getEstado().name());
        response.setFechaHora(saved.getFechaCreacion());

        return response;
    }
}