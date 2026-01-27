package com.example.EmployeeProject.service;

import com.example.EmployeeProject.dto.request.DepartmentTransferRequest;
import com.example.EmployeeProject.dto.request.EmployeeRequest;
import com.example.EmployeeProject.dto.response.DepartmentTransferResponse;
import com.example.EmployeeProject.dto.response.EmployeeResponse;

import java.util.List;


public interface EmployeeService {


    EmployeeResponse addEmployee(EmployeeRequest request);
    List<EmployeeResponse> allEmployees();
    EmployeeResponse findEmployeeById(Long id);
    void deleteEmployee(Long id);
    EmployeeResponse changeSalary(Long id, double salary);
    EmployeeResponse promotion(Long id) throws Exception;
    DepartmentTransferResponse departmentTransfer(Long id, DepartmentTransferRequest request) throws Exception;

}
