package com.pv.api.domain.repository;

import com.pv.api.domain.model.User;

import java.util.Optional;

public interface UserRepository {

    boolean existsByUsername(String username);

    User save(User user);

    Optional<User> findByUsername(String username);
}