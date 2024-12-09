package com.cisco.prj.entity;

import java.util.Objects;

public class Account {
    private double balance; // state, initialized to 0.0
    private static int count; // class data

    // default constructor
    public Account() {
        count++;
        this.balance = 0.0;
    }
    // parametrized constructor
    public Account(double amt) {
        count++;
        this.balance += amt;
    }

    public void deposit(double amt) {
        this.balance += amt; // same as balance += amt;
    }
    public double getBalance() {
        return this.balance; // same as return balance;
    }

    // class member; context has to be class
    public static int getCount() {
        return  count;
    }

    // a1.equals(a2)
    // this --> a1
    // other --> a2
    @Override
    public boolean equals(Object other) {
        Account account = (Account) other;
        return this.balance == account.balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }
}
