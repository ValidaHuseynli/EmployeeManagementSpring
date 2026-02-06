package com.example.EmployeeProject.service.impl;

import com.example.EmployeeProject.model.dto.request.DepartmentRequest;
import com.example.EmployeeProject.model.dto.response.DepartmentResponse;
import com.example.EmployeeProject.model.entity.Department;
import com.example.EmployeeProject.exception.DepartmentHasEmployeesException;
import com.example.EmployeeProject.exception.DepartmentNotFoundException;
import com.example.EmployeeProject.mapper.DepartmentMapper;
import com.example.EmployeeProject.repository.DepartmentRepository;
import com.example.EmployeeProject.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentMapper departmentMapper;
    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponse addDepartment(DepartmentRequest request) {

        Department department = departmentMapper.requestToEntity(request);
        Department save = departmentRepository.save(department);
        return departmentMapper.entityToResponse(save);

    }

    @Override
    public void deleteDepartment(Long id) throws Exception {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        if (!department.getEmployees().isEmpty()) {
            throw new DepartmentHasEmployeesException("Department has employee");
        }
        departmentRepository.delete(department);
        log.info("Deleted Successfully");
    }


}
