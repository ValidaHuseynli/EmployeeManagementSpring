package com.example.EmployeeProject.exception;

public class InvalidPromotionException extends RuntimeException {
    public InvalidPromotionException(String message) {
        super(message);
    }
}
