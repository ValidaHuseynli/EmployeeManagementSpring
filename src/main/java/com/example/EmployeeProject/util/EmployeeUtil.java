package com.example.EmployeeProject.util;

import com.example.EmployeeProject.entity.Position;
import com.example.EmployeeProject.exception.InvalidPromotionException;

public class EmployeeUtil {

    public static double validSalary(double salary){
        if(salary<=0)
            throw new IllegalArgumentException("Salary cannot be negative or zero.");
        return salary;
    }

    public static void validPosition(String position){
        try{
             Position.valueOf(position.toUpperCase()) ;
        }catch (InvalidPromotionException ex){
            System.out.println( "Position must be one of: INTERN, JUNIOR, MIDDLE, SENIOR, EXPERT");
        }

    }
}
