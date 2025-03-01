package com.jatin.bankingsystem.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "CustomerTable")
public class Customer extends User{
    @OneToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY,
        mappedBy = "CustomerTable"
    )
    private Account account;
    // private String accountNumber;

    public Customer(String name, String email, String password) {
        super(name, email, password);
        this.account = new Account();
        // this.accountNumber = accountNumber;
    }
}
