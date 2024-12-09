package com.cisco.prj.client;
import com.cisco.prj.entity.Account;

public class AccountExample {
    // public static void main(String... args) {
    // public static void main(String args[]) {
    public static void main(String[] args) {
        System.out.println(Account.getCount()); // 0
        // calling default constructor
        Account rahulAcc = new Account(); // instances of class, objects
        System.out.println(Account.getCount()); // 1
        // calls parametrized constructor
        Account swethaAcc = new Account(8000);
        System.out.println(Account.getCount()); // 2
        // Avoid
        System.out.println(swethaAcc.getCount()); // ==> Account.getCount()

        // Avoid this
//        System.out.println(rahulAcc.getCount()); // 2
//        System.out.println(swethaAcc.getCount()); // 2

        rahulAcc.deposit(4500.00);
        swethaAcc.deposit(9800.00);

        System.out.println("Rahul Account");
        System.out.println("Balance: " + rahulAcc.getBalance());

        System.out.println("Swetha Account");
        System.out.println("Balance: " + swethaAcc.getBalance());
    }
}
