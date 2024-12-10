package com.cisco.prj.client;

import com.cisco.prj.entity.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IterableExample {
    public static void main(String[] args) {
        List<Product> products = new LinkedList<>();
        products.add(new Product(42, "LG AC", 45000.00, "ELEC"));
        products.add(new Product(89, "Sony Bravia", 245000.00, "TV"));
        products.add( new Product(7, "Samsung Fold", 175000.00, "MOBILE"));
        products.add( new Product(2, "IPhone", 95000.00, "MOBILE"));
        products.add(new Product(42, "LG JOY", 98000.00, "TV"));
        products.add( new Product(42, "TATA PLAY", 5100.00, "ELEC"));

        // Iterator are like forEach loop
        // extra we have remove() method
        // iterator locks the collection once we get iterator()
        // releases the lock once iteration is complete
        Iterator<Product> iter = products.iterator();
        // ConcurrentModificationException
        products.add( new Product(4, "Junk PLAY", 5100.00, "ELEC"));

        while(iter.hasNext()) {
            Product p = iter.next();
            System.out.println(p);
            if(p.getCategory().equals("ELEC")) {
                iter.remove();
            }
        }

        // supports now
        products.add( new Product(4, "Junk PLAY", 5100.00, "ELEC"));

    }
}
