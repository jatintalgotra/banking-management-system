package com.jatin.bankingsystem.exceptions;

public class InsuffBal extends RuntimeException{
    public InsuffBal(String message){
        super(message);
    }
}
