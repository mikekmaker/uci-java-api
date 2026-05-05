package com.pv.api.application.usecase;

import com.pv.api.application.dto.MeResponse;
import com.pv.api.domain.model.User;
import com.pv.api.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class GetMeUseCase {

    private final UserRepository userRepository;

    public GetMeUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MeResponse execute(String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Sesion invalida"));

        return new MeResponse(
                user.getUserId(),
                user.getNombre(),
                user.getApellido(),
                user.getUsername()
        );
    }
}