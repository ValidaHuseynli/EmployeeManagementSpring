package com.example.EmployeeProject.repository;

import com.example.EmployeeProject.model.entity.EmployeePromotionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePromotionHistoryRepository extends JpaRepository<EmployeePromotionHistory, Long> {
}
