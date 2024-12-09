package com.cisco.prj.entity;

public class Account {
    private double balance; // state, initialized to 0.0

    public void deposit(double amt) {
        this.balance += amt; // same as balance += amt;
    }
    public double getBalance() {
        return this.balance; // same as return balance;
    }
}
