package com.example.EmployeeProject.model.dto.response;

import com.example.EmployeeProject.model.enums.Position;
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
