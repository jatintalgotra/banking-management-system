package com.jatin.bankingsystem.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime timeStamp;

    public Transaction() {}

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timeStamp = LocalDateTime.now();
    }
}
