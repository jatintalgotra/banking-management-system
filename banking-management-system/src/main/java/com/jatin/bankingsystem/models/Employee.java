package com.jatin.bankingsystem.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Employee extends User{
    // private double salary;
    
    public Employee(String name, String email, String password) {
        super(name, email, password);
    }
}
