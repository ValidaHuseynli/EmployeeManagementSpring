package com.example.EmployeeProject.service;

import com.example.EmployeeProject.model.entity.User;

public interface JwtService {
    String generateAccessToken(User user);
}
