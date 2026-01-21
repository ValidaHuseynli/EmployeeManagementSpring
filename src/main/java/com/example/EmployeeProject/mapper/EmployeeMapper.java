package com.example.EmployeeProject.mapper;

import com.example.EmployeeProject.dto.EmployeeRequest;
import com.example.EmployeeProject.dto.EmployeeResponse;
import com.example.EmployeeProject.entity.Employee;
import com.example.EmployeeProject.entity.Position;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeMapper {

    public Employee requestToEntity(EmployeeRequest request) {
        if (request == null)
            return null;

        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setSurname(request.getSurname());
        employee.setPosition(Position.valueOf(request.getPosition()));
        employee.setSalary(request.getSalary());
        return employee;

    }

    public EmployeeResponse entityToResponse(Employee employee) {
        if (employee == null)
            return null;

        EmployeeResponse response = new EmployeeResponse();
        response.setEmployeeId(employee.getEmployeeId());
        response.setName(employee.getName());
        response.setSurname(employee.getSurname());
        response.setPosition(employee.getPosition());
        response.setSalary(employee.getSalary());
        response.setCreatedAt(employee.getCreatedAt());
        response.setUpdatedAt(employee.getUpdatedAt());

        return response;
    }

    public List<EmployeeResponse> entitiesToResponses(List<Employee> emp){
        if(emp==null)
            return List.of();


        return emp.stream()
                .map(this::entityToResponse)
                .toList();
    }
}
