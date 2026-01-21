package com.example.EmployeeProject.service;

import com.example.EmployeeProject.dto.EmployeeRequest;
import com.example.EmployeeProject.dto.EmployeeResponse;
import com.example.EmployeeProject.entity.Position;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {


    EmployeeResponse addEmployee(EmployeeRequest request);
    List<EmployeeResponse> allEmployees();
    EmployeeResponse findEmployeeById(UUID id);
    void deleteEmployee(UUID id);
    EmployeeResponse changeSalary(UUID id, double salary);
    EmployeeResponse promotion(UUID id) throws Exception;
}
