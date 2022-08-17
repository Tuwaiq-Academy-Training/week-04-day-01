package com.example.springsecurity.controller;

import com.example.springsecurity.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private  final AuthService authService;


    @GetMapping("/guest")
    public ResponseEntity welcomeGuest() {
        return ResponseEntity.status(200).body("Welcome Guest");
    }

    @GetMapping("/user")
    public ResponseEntity welcomeUser() {
        return ResponseEntity.status(200).body("Welcome User");
    }

    @GetMapping("/admin")
    public ResponseEntity welcomeAdmin() {
        return ResponseEntity.status(200).body("Welcome Admin");
    }
}
