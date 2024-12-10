package com.cisco.prj.client;

import com.cisco.prj.entity.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Product> products = new LinkedList<>();
        products.add(new Product(42, "LG AC", 45000.00, "ELEC"));
        products.add(new Product(89, "Sony Bravia", 245000.00, "TV"));
        products.add( new Product(7, "Samsung Fold", 175000.00, "MOBILE"));
        products.add( new Product(2, "IPhone", 95000.00, "MOBILE"));
        products.add(new Product(42, "LG JOY", 98000.00, "TV"));
        products.add( new Product(42, "TATA PLAY", 5100.00, "ELEC"));
        // forEach accepts consumer action
        // Consumer accept
        products.stream().forEach(p -> System.out.println(p));

        // need to get only mobiles
        System.out.println("Only mobiles");
        products.stream()
                .filter(p -> p.getCategory().equals("MOBILE"))
                .forEach(p -> System.out.println(p));

        // get only the names of mobiles
        System.out.println("Names of mobiles");
        products.stream()
                .filter(p -> p.getCategory().equals("MOBILE"))
                .map(m -> m.getName())
                .forEach(p -> System.out.println(p)); // String

        // get only the names of mobiles
        System.out.println("total cost of mobiles");
        double total = products.stream()
                .filter(p -> p.getCategory().equals("MOBILE"))
                .map(m -> m.getPrice())
                        .reduce(0.0, (p1,p2) -> p1 + p2);
//                .reduce(0.0, (p1,p2) -> {
//                    System.out.println(p1 + " , " + p2);
//                    return    p1 + p2;
//                });

        System.out.println("Total " + total);

        System.out.println("Collect into other collection");

        List<String> names = products.stream()
//                .filter(p -> p.getCategory().equals("MOBILE"))
                .map(m -> m.getName())
                .collect(Collectors.toList());

        List<Product> tvs = products.stream()
                .filter(p -> p.getCategory().equals("TV"))
                .collect(Collectors.toList());

        

    }
}
