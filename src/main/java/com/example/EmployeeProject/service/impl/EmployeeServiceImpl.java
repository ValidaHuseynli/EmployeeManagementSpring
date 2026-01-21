package com.example.EmployeeProject.service.impl;

import com.example.EmployeeProject.dto.EmployeeRequest;
import com.example.EmployeeProject.dto.EmployeeResponse;
import com.example.EmployeeProject.entity.Employee;
import com.example.EmployeeProject.entity.Position;
import com.example.EmployeeProject.exception.EmployeeNotFoundException;
import com.example.EmployeeProject.mapper.EmployeeMapper;
import com.example.EmployeeProject.repository.EmployeeRepository;
import com.example.EmployeeProject.service.EmployeeService;
import com.example.EmployeeProject.util.EmployeeUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeResponse addEmployee(EmployeeRequest request) {

        Employee employee = employeeMapper.requestToEntity(request);

        EmployeeUtil.validSalary(request.getSalary());
        EmployeeUtil.validPosition(request.getPosition());


        Employee save = employeeRepository.save(employee);
        return employeeMapper.entityToResponse(save);
    }

    @Override
    public List<EmployeeResponse> allEmployees() {
        List<Employee> all = employeeRepository.findAll();
        return employeeMapper.entitiesToResponses(all);
    }

    @Override
    public EmployeeResponse findEmployeeById(UUID id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        return employeeMapper.entityToResponse(employee);
    }

    @Override
    public void deleteEmployee(UUID id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeResponse changeSalary(UUID id, double salary) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        employee.setSalary(EmployeeUtil.validSalary(salary));

        Employee save = employeeRepository.save(employee);
        return employeeMapper.entityToResponse(save);
    }

    @Override
    public EmployeeResponse promotion(UUID id) throws Exception {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        Position current = employee.getPosition();

        if (current == Position.INTERN) {
            employee.setPosition(Position.JUNIOR);
        } else if (current == Position.JUNIOR) {
            employee.setPosition(Position.MIDDLE);
        } else if (current == Position.MIDDLE) {
            employee.setPosition(Position.SENIOR);
        } else if (current == Position.SENIOR) {
            employee.setPosition(Position.EXPERT);
        } else if (current == Position.EXPERT) {
            throw new Exception("The highest Position");
        }
        Employee save = employeeRepository.save(employee);

        return employeeMapper.entityToResponse(save);
    }
}
