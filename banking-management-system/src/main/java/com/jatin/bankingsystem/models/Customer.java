package com.jatin.bankingsystem.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Customer extends User{
    @OneToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "acc_id")
    private Account account;
    // private String accountNumber;

    public Customer(String name, String email, String password) {
        super(name, email, password);
        this.account = new Account();
        // this.accountNumber = accountNumber;
    }
}
