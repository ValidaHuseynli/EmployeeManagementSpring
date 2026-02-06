package com.example.EmployeeProject.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponse {

    private Long departmentId;
    private String name;
    private Integer maxEmployeeCount;
    private String description;
}
