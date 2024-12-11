package com.cisco.prj.entity;

import com.cisco.prj.annotation.Column;
import com.cisco.prj.annotation.Table;

@Table(name="TBOOK")
public class Book {
    private  int id;
    private  String name;
    private  double price;

    public Book() {
    }

    public Book(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Column(name = "BOOK_ID", type = "NUMERIC(12)")
    public int getId() {
        return id;
    }

    @Column(name="TITLE")
    public String getName() {
        return name;
    }

    @Column(name = "AMT", type = "NUMERIC(12,2)")
    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
