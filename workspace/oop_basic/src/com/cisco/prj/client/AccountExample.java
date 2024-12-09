package com.cisco.prj.client;
import com.cisco.prj.entity.Account;

public class AccountExample {
    // public static void main(String... args) {
    // public static void main(String args[]) {
    public static void main(String[] args) {
        Account rahulAcc = new Account(); // instances of class, objects
        Account swethaAcc = new Account();

        rahulAcc.deposit(4500.00);
        swethaAcc.deposit(9800.00);

        System.out.println("Rahul Account");
        System.out.println("Balance: " + rahulAcc.getBalance());

        System.out.println("Swetha Account");
        System.out.println("Balance: " + swethaAcc.getBalance());
    }
}
