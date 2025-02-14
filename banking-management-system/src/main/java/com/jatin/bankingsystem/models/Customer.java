package com.jatin.bankingsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Customer extends User{
    @OneToOne
    private Account account;
    // private String accountNumber;

    public Customer(String name, String email, String password) {
        super(name, email, password);
        this.account = new Account();
        // this.accountNumber = accountNumber;
    }
}
