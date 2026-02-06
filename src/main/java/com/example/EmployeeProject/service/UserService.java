package com.example.EmployeeProject.service;

import com.example.EmployeeProject.model.dto.request.LoginRequest;
import com.example.EmployeeProject.model.dto.request.UserRequest;
import com.example.EmployeeProject.model.dto.response.LoginResponse;
import com.example.EmployeeProject.model.dto.response.UserResponse;

public interface UserService {

    LoginResponse login(LoginRequest request);
    UserResponse register(UserRequest request);
}
