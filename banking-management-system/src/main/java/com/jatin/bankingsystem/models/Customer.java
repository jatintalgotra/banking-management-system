package com.jatin.bankingsystem.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Customer extends User{
    private Account account;

    public Customer(String name, String email, String password,Account account) {
        super(name, email, password);
        this.account = account;
    }
}
