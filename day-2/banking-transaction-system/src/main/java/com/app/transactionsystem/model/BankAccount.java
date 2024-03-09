package com.app.transactionsystem.model;

public class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double initialBalance) {
        // TODO: Initialize the account with the provided account number and balance.
    }

    public int getAccountNumber() {
        return accountNumber;

    }

    public double getBalance() {
        return balance;
    }

    public synchronized void withdraw(double amount) {
        // TODO: Implement a thread-safe withdrawal method.
        // Deduct the specified amount from the balance, ensuring sufficient funds.
        // Print a message indicating the withdrawal transaction.
    }

    public synchronized void deposit(double amount) {
        // TODO: Implement a thread-safe deposit method.
        // Add the specified amount to the balance, ensuring a valid amount.
        // Print a message indicating the deposit transaction.
    }
}

