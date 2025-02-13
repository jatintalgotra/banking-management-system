package com.jatin.bankingsystem.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jatin.bankingsystem.models.Employee;

public interface EmployeeInterface extends JpaRepository<Employee, String>{
    Employee findByEmail(String email);

    void saveAll(List<Employee> employees);
}
