package com.klu.microservices.services;

import org.springframework.stereotype.Service;
import com.klu.microservices.model.Login;
import com.klu.microservices.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository repository;

    public AuthService(UserRepository repository) {
        this.repository = repository;
    }
    
    public boolean authenticate(String username, String password) {
        Login user = repository.findByUsername(username).orElse(null);

        return user != null &&
               user.getPassword().equals(password);
    }
}