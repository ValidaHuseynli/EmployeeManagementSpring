package com.example.EmployeeProject.exception;

public class DepartmentHasEmployeesException extends RuntimeException{
    public DepartmentHasEmployeesException(String message) {
        super(message);
    }
}
