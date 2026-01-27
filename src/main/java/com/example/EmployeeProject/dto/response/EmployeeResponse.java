package com.example.EmployeeProject.dto.response;

import com.example.EmployeeProject.entity.Department;
import com.example.EmployeeProject.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {

    private Long employeeId;
    private String name;
    private String surname;
    private Position position;
    private Double salary;
    private Department department;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
