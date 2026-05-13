package com.pv.api.application.usecase;

        import com.pv.api.application.dto.AuditoriaHeaderResponse;
        import com.pv.api.domain.repository.AuditoriaDetalleRepository;
        import com.pv.api.domain.repository.AuditoriaRepository;
        import com.pv.api.domain.repository.UserRepository;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class GetAuditoriaUseCaseImpl
        implements GetAuditoriaUseCase {

    private final AuditoriaRepository auditoriaRepository;
    private final UserRepository userRepository;
    private final AuditoriaDetalleRepository auditoriaDetalleRepository;

    public GetAuditoriaUseCaseImpl(
            AuditoriaRepository auditoriaRepository,
            UserRepository userRepository,
            AuditoriaDetalleRepository auditoriaDetalleRepository
    ) {
        this.auditoriaRepository = auditoriaRepository;
        this.userRepository = userRepository;
        this.auditoriaDetalleRepository = auditoriaDetalleRepository;
    }

    @Override
    public List<AuditoriaHeaderResponse> getAll(
            String username
    ) {

        var user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado")
                );

        var auditorias =
                auditoriaRepository.findByUserId(
                        user.getUserId()
                );

        return auditorias.stream()
                .map(auditoria -> {

                    AuditoriaHeaderResponse response =
                            new AuditoriaHeaderResponse();

                    response.setId(
                            auditoria.getId()
                    );

                    response.setLenguaje(
                            auditoria.getLenguaje()
                    );

                    response.setEstado(
                            auditoria.getEstado().name()
                    );

                    response.setFechaCreacion(
                            auditoria.getFechaCreacion()
                    );

                    return response;
                })
                .toList();
    }

    @Override
    public AuditoriaHeaderResponse getById(
            Long auditoriaId,
            String username
    ) {

        var user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado")
                );

        var auditoria =
                auditoriaRepository.findByIdAndUserId(
                        auditoriaId,
                        user.getUserId()
                ).orElseThrow(() ->
                        new RuntimeException("Auditoría no encontrada")
                );

        AuditoriaHeaderResponse response =
                new AuditoriaHeaderResponse();

        response.setId(
                auditoria.getId()
        );

        response.setLenguaje(
                auditoria.getLenguaje()
        );

        response.setEstado(
                auditoria.getEstado().name()
        );

        response.setFechaCreacion(
                auditoria.getFechaCreacion()
        );

        return response;
    }
}