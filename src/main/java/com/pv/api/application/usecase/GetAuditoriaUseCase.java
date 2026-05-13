package com.pv.api.application.usecase;

import com.pv.api.application.dto.AuditoriaHeaderResponse;
import java.util.List;

public interface GetAuditoriaUseCase {

    List<AuditoriaHeaderResponse> getAll(
            String username
    );

    AuditoriaHeaderResponse getById(
            Long auditoriaId,
            String username
    );
}