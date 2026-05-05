package com.pv.api.application.usecase;

import com.pv.api.application.dto.RegisterRequest;
import com.pv.api.application.dto.RegisterResponse;
import com.pv.api.application.exception.UserAlreadyExistsException;
import com.pv.api.domain.model.User;
import com.pv.api.domain.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserUseCase(UserRepository userRepository,
                               PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponse execute(RegisterRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistsException("Usuario ya existe");
        }

        User user = new User(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                "USER",
                request.getNombre(),
                request.getApellido(),
                true
        );

        userRepository.save(user);

        return new RegisterResponse("Usuario creado correctamente");
    }
}