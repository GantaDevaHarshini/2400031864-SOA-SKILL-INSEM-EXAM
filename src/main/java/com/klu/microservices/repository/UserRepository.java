package com.klu.microservices.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.microservices.model.Login;

public interface UserRepository
        extends JpaRepository<Login, Long> {

    Optional<Login> findByUsername(String username);
}