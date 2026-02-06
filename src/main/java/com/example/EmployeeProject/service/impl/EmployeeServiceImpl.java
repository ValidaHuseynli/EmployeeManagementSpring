package com.example.EmployeeProject.service.impl;

import com.example.EmployeeProject.model.dto.request.DepartmentTransferRequest;
import com.example.EmployeeProject.model.dto.request.EmployeeRequest;
import com.example.EmployeeProject.model.dto.response.DepartmentTransferResponse;
import com.example.EmployeeProject.model.dto.response.EmployeeResponse;
import com.example.EmployeeProject.model.entity.Employee;
import com.example.EmployeeProject.model.entity.EmployeeSalaryHistory;
import com.example.EmployeeProject.model.entity.EmployeePromotionHistory;
import com.example.EmployeeProject.model.entity.Department;
import com.example.EmployeeProject.model.enums.Position;
import com.example.EmployeeProject.exception.DepartmentNotFoundException;
import com.example.EmployeeProject.exception.EmployeeNotFoundException;
import com.example.EmployeeProject.mapper.EmployeeMapper;
import com.example.EmployeeProject.repository.DepartmentRepository;
import com.example.EmployeeProject.repository.EmployeePromotionHistoryRepository;
import com.example.EmployeeProject.repository.EmployeeRepository;
import com.example.EmployeeProject.repository.EmployeeSalaryHistoryRepository;
import com.example.EmployeeProject.service.EmployeeService;
import com.example.EmployeeProject.util.EmployeeUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final DepartmentRepository departmentRepository;
    private final EmployeeSalaryHistoryRepository empSalaryHistoryRepository;
    private final EmployeePromotionHistoryRepository empPromotionHistoryRepository;


    @Transactional
    @Override
    public EmployeeResponse addEmployee(EmployeeRequest request) {
        EmployeeUtil.validSalary(request.getSalary());
        Employee employee = employeeMapper.requestToEntity(request);
        Employee save = employeeRepository.save(employee);

        EmployeeSalaryHistory employeeSalaryHistory=new EmployeeSalaryHistory();
        employeeSalaryHistory.setSalary(employee.getSalary());
        employeeSalaryHistory.setEmployee(employee);
        empSalaryHistoryRepository.save(employeeSalaryHistory);

        EmployeePromotionHistory empPromotionHistory=new EmployeePromotionHistory();
        empPromotionHistory.setEmployee(employee);
        empPromotionHistory.setPosition(employee.getPosition());
        empPromotionHistoryRepository.save(empPromotionHistory);


        return employeeMapper.entityToResponse(save);
    }

    @Override
    public List<EmployeeResponse> allEmployees() {
        List<Employee> all = employeeRepository.findAll();
        return employeeMapper.entitiesToResponses(all);
    }

    @Override
    public EmployeeResponse findEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        return employeeMapper.entityToResponse(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeResponse changeSalary(Long id, double salary) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        EmployeeUtil.validSalary(salary);
        employee.setSalary(salary);

        Employee save = employeeRepository.save(employee);
        return employeeMapper.entityToResponse(save);
    }

    @Override
    public EmployeeResponse promotion(Long id) throws Exception {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        Position current = employee.getPosition();
        int ordinal = current.ordinal();
        Position[] values = Position.values();
        if (current == Position.EXPERT)
            throw new Exception("The highest Position");
        else current = values[ordinal + 1];

        employee.setPosition(current);

        Employee save = employeeRepository.save(employee);

        EmployeePromotionHistory employeePromotionHistory=new EmployeePromotionHistory();
        employeePromotionHistory.setEmployee(employee);
        employeePromotionHistory.setPosition(current);

        empPromotionHistoryRepository.save(employeePromotionHistory);

        return employeeMapper.entityToResponse(save);
    }

    @Transactional
    @Override
    public DepartmentTransferResponse departmentTransfer(Long id, DepartmentTransferRequest request) throws Exception {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found!"));

        Department department = departmentRepository.findById(request.getTargetDepartmentId())
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found!"));

        EmployeeSalaryHistory empSalaryHistory = new EmployeeSalaryHistory();

        Department oldDepartment = employee.getDepartment();
        Position oldPosition = employee.getPosition();
        Position newPosition = oldPosition;
        if (request.getPromote() == true) {
            EmployeeResponse promotion = promotion(id);
            newPosition = promotion.getPosition();
        }

        double newSalary = employee.getSalary();
        if (request.getNewSalary() != null) {
            newSalary = request.getNewSalary();
        }

        employee.setDepartment(department);
        employee.setSalary(request.getNewSalary());
        employee.setPosition(newPosition);
        empSalaryHistory.setEmployee(employee);
        empSalaryHistory.setSalary(newSalary);

        employeeRepository.save(employee);
        empSalaryHistoryRepository.save(empSalaryHistory);


        return DepartmentTransferResponse.builder()
                .employeeId(id)
                .oldDepartment(oldDepartment.getName())
                .newDepartment(department.getName())
                .oldPosition(oldPosition)
                .newPosition(newPosition)
                .newSalary(newSalary)
                .transferDate(LocalDateTime.now())
                .build();
    }
}
