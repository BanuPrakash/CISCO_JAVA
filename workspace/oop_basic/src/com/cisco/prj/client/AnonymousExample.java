package com.cisco.prj.client;

import com.cisco.prj.util.AddComputation;
import com.cisco.prj.util.Computation;

public class AnonymousExample {
    public static void main(String[] args) {
        Computation c = new AddComputation();
        System.out.println(c.compute(4,5)); // 9

        // c is an object of Anonymous class
        c = new Computation() {
            @Override
            public int compute(int x, int y) {
                return x - y;
            }
        };
        System.out.println(c.compute(5, 1));
        System.out.println(c.getClass());

        // Lambda expressions can be used instead of anonymous class
        // if interface has only one method to implement
//        Computation comp = (int x, int y) -> {
//                return x * y;
//            };

        // type infer
        Computation comp = (x, y) -> x * y;
        System.out.println(comp.compute(5, 4));
    }
}
