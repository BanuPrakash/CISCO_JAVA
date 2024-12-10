package com.cisco.prj.entity;

import com.cisco.prj.util.IComparable;

// implicitly inherits from java.lang.Object
// remember Liskov Substitution Principle
public abstract class Product implements IComparable {
    private  int id;
    private String name;
    private double price;

    public Product() {
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // default implementation
//    public boolean isExpensive() {
//        return  false;
//    }

    // like pure virtual function
    public abstract boolean isExpensive();

    @Override
    public int compare(Object other) {
        Product p = (Product) other;
        return (int) (this.price - p.price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
