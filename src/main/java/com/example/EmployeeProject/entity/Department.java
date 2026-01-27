package com.example.EmployeeProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer maxEmployeeCount;

    private String description;

    @OneToMany(
            mappedBy = "department",
            cascade = CascadeType.ALL
    )
    private List<Employee> employees;


}
