package com.cisco.prj.entity;

public class Account {
    private double balance; // state, initialized to 0.0
    private static int count;

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
}
