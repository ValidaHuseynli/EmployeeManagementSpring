package com.example.EmployeeProject.util;

import com.example.EmployeeProject.model.enums.Position;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EmployeeUtil {

    public static void validSalary(double salary) {
        if (salary <= 0)
            throw new IllegalArgumentException("Salary cannot be negative or zero.");

    }

    public static Position validPosition(String position) {
        if (position == null) {
            throw new NullPointerException("Position can not be null");
        } else {
            try {
                return Position.valueOf(position.toUpperCase());
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("Position must be one of: INTERN, JUNIOR, MIDDLE, SENIOR, EXPERT");
            }
        }
    }

    public static Position promotion(Position position) throws Exception {
        int ordinal = position.ordinal();
        Position[] values = Position.values();
        if (position == Position.EXPERT)
            throw new Exception("The highest Position");
        else position = values[ordinal + 1];

        return position;
    }
}
