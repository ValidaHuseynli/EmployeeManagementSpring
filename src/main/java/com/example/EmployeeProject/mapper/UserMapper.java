package com.example.EmployeeProject.mapper;

import com.example.EmployeeProject.model.dto.request.UserRequest;
import com.example.EmployeeProject.model.dto.response.UserResponse;
import com.example.EmployeeProject.model.entity.User;
import com.example.EmployeeProject.model.enums.Role;
import com.example.EmployeeProject.util.EmployeeUtil;
import com.example.EmployeeProject.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public User requestToEntity(UserRequest request){
        User user=new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(UserUtil.validRole(request.getRole()));
        return user;
    }

    public UserResponse entityToResponse(User user){
        UserResponse response=new UserResponse();
        response.setId(user.getId());
        response.setPassword(user.getPassword());
        response.setRole(String.valueOf(user.getRole()));
        response.setUsername(user.getUsername());
        return response;
    }
}
