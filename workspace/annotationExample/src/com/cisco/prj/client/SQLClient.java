package com.cisco.prj.client;

import com.cisco.prj.entity.Book;
import com.cisco.prj.entity.Employee;
import com.cisco.prj.util.ORMUtil;

public class SQLClient {
    public static void main(String[] args) {
        String SQL = ORMUtil.generateCreateSQL(Book.class);
        System.out.println(SQL);

        SQL = ORMUtil.generateCreateSQL(Employee.class);
        System.out.println(SQL);
        Book b = new Book(24, "Hibernate in Action", 1200.22);
        SQL = ORMUtil.generateInsertSQL(b);
        System.out.println(SQL);
    }
}
