package com.pv.api.application.usecase;

import com.pv.api.application.dto.AnalyzeAuditoriaRequest;
import com.pv.api.application.dto.CodeAnalysisResult;
import com.pv.api.application.usecase.AnalyzeAuditoriaUseCase;
import com.pv.api.application.dto.AnalyzeAuditoriaResponse;
import com.pv.api.domain.model.AuditStatus;
import com.pv.api.domain.model.Auditoria;
import com.pv.api.domain.model.AuditoriaDetalle;
import com.pv.api.domain.model.User;
import com.pv.api.domain.repository.AuditoriaDetalleRepository;
import com.pv.api.domain.repository.AuditoriaRepository;
import com.pv.api.domain.repository.UserRepository;
import com.pv.api.infrastructure.persistence.mapper.CodeAnalysisMapper;
import org.springframework.stereotype.Service;
import com.pv.api.domain.service.CodeAnalysisClient;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class AnalyzeAuditoriaUseCaseImpl
        implements AnalyzeAuditoriaUseCase {

    private final AuditoriaRepository auditoriaRepository;
    private final UserRepository userRepository;
    private final CodeAnalysisClient codeAnalysisClient;
    private final CodeAnalysisMapper codeAnalysisMapper;

    private final AuditoriaDetalleRepository auditoriaDetalleRepository;

    public AnalyzeAuditoriaUseCaseImpl(
            AuditoriaRepository auditoriaRepository,
            UserRepository userRepository,
            CodeAnalysisClient codeAnalysisClient,
            CodeAnalysisMapper codeAnalysisMapper,
            AuditoriaDetalleRepository auditoriaDetalleRepository
    ) {
        this.auditoriaRepository = auditoriaRepository;
        this.userRepository = userRepository;
        this.codeAnalysisClient = codeAnalysisClient;
        this.codeAnalysisMapper = codeAnalysisMapper;
        this.auditoriaDetalleRepository = auditoriaDetalleRepository;
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

        String analysisResult =
                codeAnalysisClient.analyzeCode(
                        request.getCodigoFuente(),
                        request.getLenguaje(),
                        request.getTipoAnalisis()
                );

        CodeAnalysisResult parsed =
                codeAnalysisMapper.toResult(analysisResult);

        auditoria.setResultadoGeneral(analysisResult);
        auditoria.setCodigoExplicado(parsed.getPedagogicalExplanation());
        auditoria.setReingenieria(parsed.getRefactoredCode());
        auditoria.setEstado(AuditStatus.COMPLETED);
        Auditoria saved =
                auditoriaRepository.save(auditoria);

        var detalles =
                codeAnalysisMapper.toDetalles(parsed);

        detalles.forEach(detalle ->
                detalle.setAuditoriaId(saved.getId())
        );

        saved.setDetalles(detalles);

        auditoriaRepository.save(saved);

        AnalyzeAuditoriaResponse response =
                new AnalyzeAuditoriaResponse();

        response.setAuditoriaId(saved.getId());
        response.setEstado(saved.getEstado().name());
        response.setFechaHora(saved.getFechaCreacion());

        return response;
    }
}