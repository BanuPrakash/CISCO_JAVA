package com.cisco.prj.client;

import com.cisco.prj.entity.Product;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
//        Set<Product> products = new HashSet<>();
//        Set<Product> products = new TreeSet<>();
        Set<Product> products = new TreeSet<>((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        products.add(new Product(42, "LG AC", 45000.00, "ELEC"));
        products.add(new Product(89, "Sony Bravia", 245000.00, "TV"));
        products.add( new Product(7, "Samsung Fold", 175000.00, "MOBILE"));
        products.add( new Product(2, "IPhone", 95000.00, "MOBILE"));
        products.add(new Product(452, "LG JOY", 98000.00, "TV"));
        products.add( new Product(421, "TATA PLAY", 5100.00, "ELEC"));
        // duplicate
        products.add( new Product(7, "Samsung Fold", 175000.00, "MOBILE"));

        for(Product p : products) {
            System.out.println(p);
        }
    }
}
