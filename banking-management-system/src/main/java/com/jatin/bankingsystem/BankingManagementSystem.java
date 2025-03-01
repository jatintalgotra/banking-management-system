package com.jatin.bankingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class BankingManagementSystem {
    public static void main(String[] args) {
        SpringApplication.run(BankingManagementSystem.class, args);

        
    }
}