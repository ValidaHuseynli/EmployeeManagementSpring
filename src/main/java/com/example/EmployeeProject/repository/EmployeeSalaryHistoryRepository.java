package com.example.EmployeeProject.repository;

import com.example.EmployeeProject.entity.EmployeeSalaryHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSalaryHistoryRepository extends JpaRepository<EmployeeSalaryHistory, Long> {
}
