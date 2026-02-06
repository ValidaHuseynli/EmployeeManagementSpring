package com.example.EmployeeProject.controller;

import com.example.EmployeeProject.model.dto.request.LoginRequest;
import com.example.EmployeeProject.model.dto.request.UserRequest;
import com.example.EmployeeProject.model.dto.response.LoginResponse;
import com.example.EmployeeProject.model.dto.response.UserResponse;
import com.example.EmployeeProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping("/login")
    LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRequest request) {
        return userService.register(request);
    }
}
