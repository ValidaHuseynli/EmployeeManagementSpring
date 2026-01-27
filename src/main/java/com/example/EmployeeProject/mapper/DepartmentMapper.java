package com.example.EmployeeProject.mapper;

import com.example.EmployeeProject.dto.request.DepartmentRequest;
import com.example.EmployeeProject.dto.response.DepartmentResponse;
import com.example.EmployeeProject.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

   public DepartmentResponse entityToResponse(Department department){
        DepartmentResponse response=new DepartmentResponse();
        response.setName(department.getName());
        response.setDescription(department.getDescription());
        response.setMaxEmployeeCount(department.getMaxEmployeeCount());
        response.setMaxEmployeeCount(department.getMaxEmployeeCount());
        response.setDepartmentId(department.getDepartmentId());

        return response;
    }

   public Department requestToEntity(DepartmentRequest request){
        Department department=new Department();

        department.setDescription(request.getDescription());
        department.setName(request.getName());
        department.setMaxEmployeeCount(request.getMaxEmployeeCount());

        return department;
    }

}
