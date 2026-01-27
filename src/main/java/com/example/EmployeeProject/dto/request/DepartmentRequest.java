package com.example.EmployeeProject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequest{

    private String name;
    private Integer maxEmployeeCount;
    private String description;
}
