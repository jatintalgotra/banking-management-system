package com.jatin.bankingsystem.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jatin.bankingsystem.models.Customer;

public interface CustomerInterface extends JpaRepository<Customer, String>{
    Customer findbyEmail(String email);

    void saveAll(List<Customer> customers);
}
