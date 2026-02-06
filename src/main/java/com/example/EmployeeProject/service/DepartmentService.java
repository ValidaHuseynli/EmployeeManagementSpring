package com.example.EmployeeProject.service;

import com.example.EmployeeProject.model.dto.request.DepartmentRequest;
import com.example.EmployeeProject.model.dto.response.DepartmentResponse;


public interface DepartmentService {

    DepartmentResponse addDepartment(DepartmentRequest request);

    void deleteDepartment(Long id) throws Exception;


}
