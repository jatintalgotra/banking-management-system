package com.jatin.bankingsystem.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jatin.bankingsystem.models.Account;

public interface AccountInterface extends JpaRepository<Account, String> {
    void saveAll(List<Account> accounts);
}
