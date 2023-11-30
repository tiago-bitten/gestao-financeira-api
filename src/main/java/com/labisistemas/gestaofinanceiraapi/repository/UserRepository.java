package com.labisistemas.gestaofinanceiraapi.repository;

import com.labisistemas.gestaofinanceiraapi.enterprise.CustomQuerydslPredicateExecutor;
import com.labisistemas.gestaofinanceiraapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, CustomQuerydslPredicateExecutor<User> {
    Optional<User> findByEmail(String email);
}
