package com.pv.api.infrastructure.persistence;

import com.pv.api.domain.model.User;
import com.pv.api.domain.repository.UserRepository;
import com.pv.api.infrastructure.persistence.entity.UserEntity;
import com.pv.api.infrastructure.persistence.repository.SpringDataUserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final SpringDataUserRepository jpaRepository;

    public UserRepositoryImpl(SpringDataUserRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public boolean existsByUsername(String username) {
        return jpaRepository.existsByUsername(username);
    }

    @Override
    public User save(User user) {

        UserEntity entity = new UserEntity();
        entity.setUserId(user.getUserId());
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setRole(user.getRole());
        entity.setNombre(user.getNombre());
        entity.setApellido(user.getApellido());
        entity.setFechaCreacion(user.getFechaCreacion());
        entity.setFechaActualizacion(user.getFechaActualizacion());
        entity.setActivo(user.getActivo());

        UserEntity saved = jpaRepository.save(entity);

        return new User(
                saved.getUserId(),
                saved.getUsername(),
                saved.getPassword(),
                saved.getRole(),
                saved.getNombre(),
                saved.getApellido(),
                saved.getFechaCreacion(),
                saved.getFechaActualizacion(),
                saved.getActivo()
        );
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return jpaRepository.findByUsername(username)
                .map(e -> new User(
                        e.getUserId(),
                        e.getUsername(),
                        e.getPassword(),
                        e.getRole(),
                        e.getNombre(),
                        e.getApellido(),
                        e.getFechaCreacion(),
                        e.getFechaActualizacion(),
                        e.getActivo()
                ));
    }
}