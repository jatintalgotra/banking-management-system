package com.jatin.bankingsystem.models;

// import java.util.ArrayList;
// import java.util.List;
import java.util.UUID;

// import com.jatin.bankingsystem.exceptions.InsuffBal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Account {
    @Id
    private String accountNumber = UUID.randomUUID().toString();
    private double balance;

    public Account() {
    }

    public void display() {
        // System.out.println("Customer Name: " + Customer);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    
}
