package com.example.EmployeeProject.controller;

import com.example.EmployeeProject.dto.request.DepartmentRequest;
import com.example.EmployeeProject.dto.response.DepartmentResponse;
import com.example.EmployeeProject.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/addDepartment")
    DepartmentResponse addDep(@RequestBody DepartmentRequest request){
        return departmentService.addDepartment(request);
    }

    @DeleteMapping("/{id}")
    void deleteDepartment(@PathVariable Long id) throws Exception {
        departmentService.deleteDepartment(id);
    }
}
