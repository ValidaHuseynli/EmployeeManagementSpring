package com.example.EmployeeProject.util;

import com.example.EmployeeProject.entity.Position;

public class EmployeeUtil {

    public static void validSalary(double salary){
        if(salary<=0)
            throw new IllegalArgumentException("Salary cannot be negative or zero.");

    }

    public static Position validPosition(String position){
        if(position==null){
            throw new NullPointerException("Position can not be null");
        }else {
            try{
                return Position.valueOf(position.toUpperCase());
            }catch (IllegalArgumentException ex){
                throw new IllegalArgumentException("Position must be one of: INTERN, JUNIOR, MIDDLE, SENIOR, EXPERT");
            }
        }


    }
}
