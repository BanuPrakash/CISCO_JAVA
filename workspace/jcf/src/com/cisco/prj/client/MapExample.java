package com.cisco.prj.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Double> bookMap = new HashMap<>();
        // key/value
        bookMap.put("Java", 980.00);
        bookMap.put("Oracle", 1980.00);
        bookMap.put("JavaScript", 1200.00);
        bookMap.put("AWS", 7880.00);
        bookMap.put("React", 680.00);

        // if key is same it overwrites
        bookMap.put("JavaScript", 600.00);

        System.out.println("Cost of AWS " + bookMap.get("AWS")); // 7880.00
        System.out.println("Cost of JavaScript " + bookMap.get("JavaScript")); // 600

        // traverse thro key/value pair
        bookMap.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });

        Set<String> keys  = bookMap.keySet();
        for(String key : keys) {
            System.out.println(key + " : " + bookMap.get(key));
        }
    }
}
