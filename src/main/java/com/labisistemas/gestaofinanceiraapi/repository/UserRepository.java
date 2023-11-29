package com.labisistemas.gestaofinanceiraapi.repository;

import com.labisistemas.gestaofinanceiraapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
