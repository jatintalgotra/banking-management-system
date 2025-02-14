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
    private long from;
    private long to;
    private double amount;
    private LocalDateTime timeStamp;

    public Transaction() {}

    public Transaction(String type,long from, long to, double amount) {
        this.to = to;
        this.from = from;
        this.type = type;
        this.amount = amount;
        this.timeStamp = LocalDateTime.now();
    }
}
