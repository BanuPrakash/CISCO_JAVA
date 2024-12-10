package com.cisco.prj.client;

import com.cisco.prj.entity.Circle;
import com.cisco.prj.entity.Mobile;
import com.cisco.prj.entity.Product;
import com.cisco.prj.entity.Tv;
import com.cisco.prj.util.Utility;

import java.util.Comparator;

public class SortClient {
    public static void main(String[] args) {
        Product[] products = new Product[5]; // array of pointers
        // upcasting
        products[0] = new Mobile(23, "iPhone 15", 98000.00, "5G");
        products[1] = new Tv(52, "Sony Bravia", 2_34_000.00, "OLED");
        products[2] = new Tv(51, "Onida", 4200.00, "CRT");
        products[3] = new Mobile(90, "MotoG", 8900, "5G");
        products[4] = new Mobile(81, "Oppo", 21000,"5G");

        Utility.sort(products);

        for(Product p : products) {
            System.out.println(p); // toString
        }
        Circle[] circles = new Circle[4];
        circles[0] = new Circle(43);
        circles[1] = new Circle(4);
        circles[2] = new Circle(21);
        circles[3] = new Circle(2);

        Utility.sort(circles);

        for(Circle c : circles) {
            System.out.println(c.getRadius());
        }
    }
}
