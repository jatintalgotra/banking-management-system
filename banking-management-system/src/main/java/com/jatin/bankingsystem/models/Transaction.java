package com.jatin.bankingsystem.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Getter
@Setter
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private long fromAccount;
    private long toAccount;
    private double amount;
    private LocalDateTime timeStamp;

    public Transaction() {}

    public Transaction(String type,long fromAccount, long toAccount, double amount) {
        this.toAccount = toAccount;
        this.fromAccount = fromAccount;
        this.type = type;
        this.amount = amount;
        this.timeStamp = LocalDateTime.now();
    }
}
