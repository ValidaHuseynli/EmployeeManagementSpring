package com.example.EmployeeProject.model.dto.request;

import com.example.EmployeeProject.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

    private String name;
    private String surname;
    private String position;
    private Double salary;
    private Long departmentId;


}
