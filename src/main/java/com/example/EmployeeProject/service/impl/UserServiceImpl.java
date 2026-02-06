package com.example.EmployeeProject.service.impl;

import com.example.EmployeeProject.exception.UserNotFoundException;
import com.example.EmployeeProject.mapper.UserMapper;
import com.example.EmployeeProject.model.dto.request.LoginRequest;
import com.example.EmployeeProject.model.dto.request.UserRequest;
import com.example.EmployeeProject.model.dto.response.LoginResponse;
import com.example.EmployeeProject.model.dto.response.UserResponse;
import com.example.EmployeeProject.model.entity.User;
import com.example.EmployeeProject.repository.UserRepository;
import com.example.EmployeeProject.security.JwtService;
import com.example.EmployeeProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    @Override
    public LoginResponse login(LoginRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
                request.getPassword()));

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User Not Found!"));

        String s = jwtService.generateAccessToken(user);
        return  LoginResponse.builder().accessToken(s).build();
    }

    @Override
    public UserResponse register(UserRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        User user = userMapper.requestToEntity(request);
        User save = userRepository.save(user);
        return userMapper.entityToResponse(save);

    }
}
