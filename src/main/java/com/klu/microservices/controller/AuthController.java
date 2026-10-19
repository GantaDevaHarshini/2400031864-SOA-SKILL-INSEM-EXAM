package com.klu.microservices.controller;

import java.util.Map;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.klu.microservices.model.Login;
import com.klu.microservices.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }
    

    @PostMapping("/login-db")
    public ResponseEntity<Map<String, String>> login(
            @RequestBody Login request) {

        if (service.authenticate(
                request.getUsername(),
                request.getPassword())) {

            return ResponseEntity.ok(
                Map.of("message", "Authentication Successful"));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(Map.of("message", "Authentication Failed"));
    }
}