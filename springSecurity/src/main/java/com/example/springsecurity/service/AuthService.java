package com.example.springsecurity.service;

import com.example.springsecurity.model.User;
import com.example.springsecurity.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;


    public List<User> getAllUser(){
        return authRepository.findAll();
    }

    public void register(User user){
        authRepository.save(user);
    }
}
