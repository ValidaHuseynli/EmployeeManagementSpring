package com.example.EmployeeProject.dto.response;

import com.example.EmployeeProject.entity.Position;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DepartmentTransferResponse {
    private Long employeeId;
    private String oldDepartment;
    private String newDepartment;
    private Position oldPosition;
    private Position newPosition;
    private Double newSalary;
    private LocalDateTime transferDate;
}
