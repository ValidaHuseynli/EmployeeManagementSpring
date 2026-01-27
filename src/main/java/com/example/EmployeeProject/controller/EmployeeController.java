package com.example.EmployeeProject.controller;

import com.example.EmployeeProject.dto.request.DepartmentTransferRequest;
import com.example.EmployeeProject.dto.request.EmployeeRequest;
import com.example.EmployeeProject.dto.response.DepartmentTransferResponse;
import com.example.EmployeeProject.dto.response.EmployeeResponse;
import com.example.EmployeeProject.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final EmployeeService empService;

    @PostMapping("/addEmp")
    EmployeeResponse addEmp(@RequestBody EmployeeRequest request){
        return empService.addEmployee(request);
    }

    @GetMapping("/all")
    List<EmployeeResponse> allEmp(){
        return empService.allEmployees();
    }

    @GetMapping("/{id}")
    EmployeeResponse findById(@PathVariable Long id){
        return empService.findEmployeeById(id);
    }


    @DeleteMapping("/delete/{id}")
    void deleteEmp(@PathVariable Long id){
        empService.deleteEmployee(id);
        log.info("Delete successfully!");
    }

    @PatchMapping("/changeSalary/{id}")
    EmployeeResponse changeSalary(@PathVariable Long id, double salary){
         return empService.changeSalary(id, salary);
    }

    @PatchMapping("/promote/{id}")
    EmployeeResponse promote(@PathVariable Long id) throws Exception {
        return empService.promotion(id);
    }

    @PatchMapping("/transferDepartment/{id}")
    DepartmentTransferResponse departmentTransfer(@PathVariable Long id, @RequestBody DepartmentTransferRequest request) throws Exception {
        return empService.departmentTransfer(id, request);
    }



}
