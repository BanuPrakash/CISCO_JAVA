package com.cisco.prj.client;

import com.cisco.prj.entity.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionCovarianceTry {
    public static void main(String[] args) {
        // Collections are not covariant
       //  List<Object>  elems = new ArrayList<String>();
        List<Product> products = new LinkedList<>();
        products.add(new Product(42, "LG AC", 45000.00, "ELEC"));
        products.add(new Product(89, "Sony Bravia", 245000.00, "TV"));
        products.add( new Product(7, "Samsung Fold", 175000.00, "MOBILE"));
        products.add( new Product(2, "IPhone", 95000.00, "MOBILE"));
        products.add(new Product(42, "LG JOY", 98000.00, "TV"));
        products.add( new Product(42, "TATA PLAY", 5100.00, "ELEC"));

        List<Integer> intList = Arrays.asList(4,6,11,66);

        printData(products);
        printData(intList);
    }
    // ? ==> unknown type; can point to any type
    // ? allows only accessor and not mutation
    private static void printData(List<?> elems) {
//        elems.add(8);
        for(Object o : elems) {
            System.out.println(o);
        }
    }
}
