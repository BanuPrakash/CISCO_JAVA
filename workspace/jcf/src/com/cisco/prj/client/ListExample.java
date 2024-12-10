package com.cisco.prj.client;

import com.cisco.prj.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
//        List<Product> products = new ArrayList<>();
        List<Product> products = new LinkedList<>();
        products.add(new Product(42, "LG AC", 45000.00, "ELEC"));
        products.add(new Product(89, "Sony Bravia", 245000.00, "TV"));
        products.add( new Product(7, "Samsung Fold", 175000.00, "MOBILE"));
        products.add( new Product(2, "IPhone", 95000.00, "MOBILE"));
        products.add(new Product(42, "LG JOY", 98000.00, "TV"));
        products.add( new Product(42, "TATA PLAY", 5100.00, "ELEC"));

        for(Product p : products) {
            System.out.println(p); // ordered
        }

        //  Arrays.sort(products); // Comparable
        Collections.sort(products); // Comparable

        System.out.println("Natural Comparison");
        for(Product p : products) {
            System.out.println(p); // ordered
        }

        System.out.println("By Price");

        Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())); // Comparator
        for(Product p : products) {
            System.out.println(p); // ordered
        }
    }
}
