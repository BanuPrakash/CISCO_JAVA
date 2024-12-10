package com.cisco.prj.client;

import com.cisco.prj.entity.Product;

import java.util.Arrays;
import java.util.Comparator;

public class ProductClient {
    public static void main(String[] args) {
        Product[] products = new Product[6];
        products[0] = new Product(42, "LG AC", 45000.00, "ELEC");
        products[1] = new Product(89, "Sony Bravia", 245000.00, "TV");
        products[2] = new Product(7, "Samsung Fold", 175000.00, "MOBILE");
        products[3] = new Product(2, "IPhone", 95000.00, "MOBILE");
        products[4] = new Product(42, "LG JOY", 98000.00, "TV");
        products[5] = new Product(42, "TATA PLAY", 5100.00, "ELEC");

        Arrays.sort(products); // Comparable

        for(Product p : products) {
            System.out.println(p); //toString
        }

        // clients requirement
        System.out.println("*** SORT BY PRICE ****");
        Arrays.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                // 54.5 - 54.1 ==> 0
//                return (int)(o1.getPrice() - o2.getPrice());
                if(o1.getPrice() > o2.getPrice()) {
                    return  1;
                } else if (o2.getPrice() > o1.getPrice()) {
                    return  -1;
                }
                return  0;
            }
        }); // Comparator

        for(Product p : products) {
            System.out.println(p); //toString
        }

        // clients requirement
        System.out.println("*** SORT BY NAME ****");
        Arrays.sort(products, (o1, o2) -> o1.getName().compareTo(o2.getName())); // Comparator

        for(Product p : products) {
            System.out.println(p); //toString
        }
    }
}
