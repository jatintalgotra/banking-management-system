package com.jatin.bankingsystem.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jatin.bankingsystem.models.Customer;

public interface CustomerDB extends JpaRepository<Customer, Integer>{
    Customer findByEmail(String email);

    void saveAll(List<Customer> customers);
}
