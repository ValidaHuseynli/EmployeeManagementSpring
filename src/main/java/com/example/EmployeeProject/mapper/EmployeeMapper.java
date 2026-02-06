package com.example.EmployeeProject.mapper;

import com.example.EmployeeProject.model.dto.request.EmployeeRequest;
import com.example.EmployeeProject.model.dto.response.EmployeeResponse;
import com.example.EmployeeProject.model.entity.Department;
import com.example.EmployeeProject.model.entity.Employee;
import com.example.EmployeeProject.exception.DepartmentNotFoundException;
import com.example.EmployeeProject.repository.DepartmentRepository;
import com.example.EmployeeProject.util.EmployeeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {

    private final DepartmentRepository departmentRepository;

    public Employee requestToEntity(EmployeeRequest request) {
        if (request == null)
            return null;

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));

        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setSurname(request.getSurname());
        employee.setPosition(EmployeeUtil.validPosition(request.getPosition()));
        employee.setSalary(request.getSalary());
        employee.setDepartment(department);
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
        response.setDepartmentName(employee.getDepartment().getName());
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
