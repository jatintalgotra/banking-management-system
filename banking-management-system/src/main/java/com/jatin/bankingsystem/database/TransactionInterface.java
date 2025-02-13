package com.jatin.bankingsystem.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jatin.bankingsystem.models.Transaction;

public interface TransactionInterface extends JpaRepository<Transaction, String>{
    void saveAll(List<Transaction> transactions);
}
