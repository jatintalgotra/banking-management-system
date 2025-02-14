package com.jatin.bankingsystem.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jatin.bankingsystem.models.Account;

public interface AccountDB extends JpaRepository<Account, String> {
    void saveAll(List<Account> accounts);
    Account findByAccountNumber(String accountNumber);
    // void save(Account account, String accountNumber);
}
