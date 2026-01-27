package com.example.EmployeeProject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentTransferRequest {

    private Long targetDepartmentId;
    private Double newSalary;
    private Boolean promote;
}
