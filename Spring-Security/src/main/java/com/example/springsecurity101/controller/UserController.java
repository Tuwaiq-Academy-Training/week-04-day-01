package com.example.springsecurity101.controller;


import com.example.springsecurity101.model.ApiResponse;
import com.example.springsecurity101.model.Users;
import com.example.springsecurity101.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("api/v1/")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping("register")
    public ResponseEntity<?> addUser(@RequestBody @Valid Users user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }

        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("New User added",200));
    }

    @GetMapping("user")
    public ResponseEntity<?> user(){
        return ResponseEntity.status(200).body(new ApiResponse("Hello User",200));
    }

    @GetMapping("admin")
    public ResponseEntity<?> admin(){
        return ResponseEntity.status(200).body("Hello Admin");
    }
}
