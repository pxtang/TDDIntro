package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by pxtang on 7/13/15.
 */
public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public int withdraw(int amount) {
        if (amount > balance)
            return 0;

        balance -= amount;
        return amount;
    }
}
