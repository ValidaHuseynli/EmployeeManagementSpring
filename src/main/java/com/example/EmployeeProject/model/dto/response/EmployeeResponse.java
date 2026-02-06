package com.example.EmployeeProject.model.dto.response;

import com.example.EmployeeProject.model.enums.Position;
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
    private String departmentName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
