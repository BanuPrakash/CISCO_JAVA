package com.cisco.prj.client;

import com.cisco.prj.entity.Mobile;
import com.cisco.prj.entity.Product;
import com.cisco.prj.entity.Tv;

public class ProductClient {
    public static void main(String[] args) {
        Product[] products = new Product[5]; // array of pointers
        // upcasting
        products[0] = new Mobile(23, "iPhone 15", 98000.00, "5G");
        products[1] = new Tv(52, "Sony Bravia", 2_34_000.00, "OLED");
        products[2] = new Tv(51, "Onida", 4200.00, "CRT");
        products[3] = new Mobile(90, "MotoG", 8900, "5G");
        products[4] = new Mobile(81, "Oppo", 21000,"5G");
        printExpensiveProducts(products);
        printDetails(products);
    }

    private static void printDetails(Product[] products) {
        // enhanced for each loop
        for(Product p: products) {
            System.out.println(p.getName() + ", " + p.getPrice());
            // type checking, loose checking as in family of
            if(p instanceof Mobile) {
                // down-casting
                Mobile m = (Mobile) p;
                System.out.println(m.getConnectivity());
            }
            // type checking, strict checking
            if(p.getClass() == Tv.class) {
                // down-casting
                Tv t = (Tv) p;
                System.out.println(t.getScreenType());
            }
            System.out.println("******");
        }
    }

    // OCP
    private static void printExpensiveProducts(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            if(products[i].isExpensive()) { // dynamic binding, polymorphism
                System.out.println(products[i].getName() + " is expensive!!!");
            } else {
                System.out.println(products[i].getName() + " is not expensive!!!");

            }
        }
    }
}
