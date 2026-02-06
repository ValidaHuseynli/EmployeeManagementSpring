package com.example.EmployeeProject.controller;

import com.example.EmployeeProject.model.dto.request.DepartmentRequest;
import com.example.EmployeeProject.model.dto.response.DepartmentResponse;
import com.example.EmployeeProject.service.DepartmentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/department")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/addDep")
    DepartmentResponse addDep(@RequestBody DepartmentRequest request){
        return departmentService.addDepartment(request);
    }

    @DeleteMapping("/{id}")
    void deleteDepartment(@PathVariable Long id) throws Exception {
        departmentService.deleteDepartment(id);
        log.info("Deleted successfully!");
    }
}
