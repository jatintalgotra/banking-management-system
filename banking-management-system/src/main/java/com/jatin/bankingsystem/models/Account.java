package com.jatin.bankingsystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.jatin.bankingsystem.exceptions.InsuffBal;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Account {
    private String accountNumber = UUID.randomUUID().toString();
    private double balance;
    private long customerID;
    private String accountType;
    private List<Transaction> transactionHistory = new ArrayList<>();

    public Account(String accountNumber, double balance, long customerID, String type) {
        this.balance = 0;
        this.customerID = customerID;
        this.accountType = type;
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount));  // Assuming you have a Transaction class
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
        } else {
            throw new InsuffBal("Insufficient balance! Available balance: "+ balance);
        }
    }
}
