package com.example.EmployeeProject.controller;

import com.example.EmployeeProject.dto.EmployeeRequest;
import com.example.EmployeeProject.dto.EmployeeResponse;
import com.example.EmployeeProject.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    private final EmployeeService empService;

    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    @PostMapping("/addEmp")
    EmployeeResponse addEmp(@RequestBody EmployeeRequest request){
        return empService.addEmployee(request);
    }

    @GetMapping("/all")
    List<EmployeeResponse> allEmp(){
        return empService.allEmployees();
    }

    @GetMapping("/{id}")
    EmployeeResponse findById(@PathVariable UUID id){
        return empService.findEmployeeById(id);
    }


    @DeleteMapping("/delete/{id}")
    void deleteEmp(@PathVariable UUID id){
        empService.deleteEmployee(id);
        System.out.println("Successfully deleted!");
    }

    @PatchMapping("/changeSalary/{id}")
    EmployeeResponse changeSalary(@PathVariable UUID id, double salary){
         return empService.changeSalary(id, salary);
    }

    @PatchMapping("/promote/{id}")
    EmployeeResponse promote(@PathVariable UUID id) throws Exception {
        return empService.promotion(id);
    }




}
