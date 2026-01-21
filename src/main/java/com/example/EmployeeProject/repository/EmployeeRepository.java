package com.example.EmployeeProject.repository;

import com.example.EmployeeProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface EmployeeRepository extends JpaRepository<Employee, UUID> {



    void deleteByEmployeeId(UUID employeeId);
}
