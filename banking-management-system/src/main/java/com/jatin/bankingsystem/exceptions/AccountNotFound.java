package com.jatin.bankingsystem.exceptions;

public class AccountNotFound extends RuntimeException {
    public AccountNotFound(String message){
        super(message);
    }
}
