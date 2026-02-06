package com.example.EmployeeProject.util;

import com.example.EmployeeProject.model.enums.Role;

public class UserUtil {
    public static Role validRole(String role){
        if(role==null){
            throw new NullPointerException("Role can not be null");
        }else {
            try{
                return Role.valueOf(role.toUpperCase());
            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException("Role can be ADMIN, USER");
            }
        }
    }
}
