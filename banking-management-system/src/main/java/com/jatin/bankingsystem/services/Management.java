package com.jatin.bankingsystem.services;

import java.util.Scanner;

import com.jatin.bankingsystem.database.AccountDB;
import com.jatin.bankingsystem.database.CustomerDB;
import com.jatin.bankingsystem.database.EmployeeDB;
import com.jatin.bankingsystem.database.TransactionDB;
import com.jatin.bankingsystem.exceptions.AccountNotFound;
import com.jatin.bankingsystem.exceptions.InsuffBal;
import com.jatin.bankingsystem.exceptions.UnauthorizedException;
import com.jatin.bankingsystem.models.Account;
import com.jatin.bankingsystem.models.Customer;
import com.jatin.bankingsystem.models.Employee;
import com.jatin.bankingsystem.models.Transaction;



public class Management {
    private AccountDB accountDb;
    private CustomerDB customerDb;
    private EmployeeDB employeeDb;
    private TransactionDB transactionDb;
    private Scanner sc;

    private Employee employee;
    private Customer customer;
    private Account account;

    public void addCustomer() {
        System.out.println("Enter customer name: ");
        String name = sc.nextLine();
        System.out.println("Enter customer email: ");
        String email = sc.nextLine();
        System.out.println("Enter customer password: ");
        String password = sc.nextLine();
        // System.out.println("Enter initial Account Balance: ");
        // double balance = sc.nextInt();

        // Account account = new Account(balance,customer.getUserId(), );
        Customer customer = new Customer(name, email, password);
        accountDb.save(customer.getAccount());
        customerDb.save(customer);
        System.out.println("Customer created successfully!");
    }

    public void addEmployee() {
        System.out.println("Enter employee name:");
        String name = sc.nextLine();
        System.out.println("Enter employee email:");
        String email = sc.nextLine();
        System.out.println("Enter employee password:");
        String password = sc.nextLine();
        Employee employee = new Employee(name, email, password);
        employeeDb.save(employee);
        System.out.println("Employee created successfully!");
    }

    public void employeeLogin() {
        System.out.println("Enter employee email:");
        String email = sc.nextLine();
        System.out.println("Enter password:");
        String pasword = sc.nextLine();
        Employee employee = employeeDb.findByEmail(email);
        try {
            if (employee.getPassword().equals(pasword)) {
                this.employee = employee;
                System.out.println("Login successful!");
            } else {
                throw new UnauthorizedException("Unauthorized");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void customerLogin() {
        System.out.println("Enter customer email:");
        String email = sc.nextLine();
        System.out.println("Enter password:");
        String pasword = sc.nextLine();
        Customer customer = customerDb.findByEmail(email);
        try {
            if (customer.getPassword().equals(pasword)) {
                this.customer = customer;
                this.account = customer.getAccount();
                System.out.println("Login successful!");
            } else {
                throw new UnauthorizedException("Unauthorized");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    public void logout() {
        this.employee = null;
        this.customer = null;
        this.account = null;
        System.out.println("Logged out successfully!");
    }

    public void sendMoney() {
        try {
            // validation
            if (this.employee != null) {
                throw new UnauthorizedException("Employee cant send money");
            }
            if (this.customer == null) {
                throw new UnauthorizedException("Unauthorized");
            }

            System.out.println("Enter receiver's email:");
            String receiverEmail = sc.nextLine();
            System.out.println("Enter amount to send:");
            double amount = sc.nextDouble();
            Customer receiver = customerDb.findByEmail(receiverEmail);
            Account senderAccount = accountDb.findByAccountNumber(customer.getAccount().getAccountNumber());

            if (receiver == null) {
                throw new AccountNotFound("Receiver not found");
            }
            Account receiverAccount = accountDb.findByAccountNumber(receiver.getAccount().getAccountNumber());
            if (senderAccount.getBalance() < amount) {
                throw new RuntimeException("Insufficient balance");
            }
            senderAccount.setBalance(senderAccount.getBalance() - amount);
            receiverAccount.setBalance(receiverAccount.getBalance() + amount);
            
            Transaction transaction = new Transaction("Transfer", customer.getUserId(),receiver.getUserId(), amount);

            // saving
            transactionDb.save(transaction);
            accountDb.save(senderAccount);
            accountDb.save(receiverAccount);
            System.out.println("Money sent successfully!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void depositMoney(double amount) {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
            Transaction transaction = new Transaction("Deposit", customer.getUserId(), customer.getUserId(), amount);
            transactionDb.save(transaction);
            System.out.println("Depost successful!");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw (double amount) throws RuntimeException{
        if (amount <= account.getBalance()) {
            Transaction transaction = new Transaction("Withdraw", customer.getUserId(), customer.getUserId(), amount);
            transactionDb.save(transaction);
            System.out.println("Withdraw successful!");
        } else {
            throw new InsuffBal("Insufficient balance! Available balance: "+ account.getBalance());
        }
    }

    public void viewAccountDetails(){
        System.out.println("Account Details:");
        account.display();
    }

    public void viewUserDetails(){
        if(employee != null){
            employee.display();
        }
        if(customer != null){
            customer.display();
        }
    }

}
