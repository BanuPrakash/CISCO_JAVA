package com.cisco.prj.util;

public class Utility {
    // pass only comparable elements to sort
    // arrays are reference type; call by reference
    // program to contract
    public static void sort(IComparable[] elements) {
        for (int i = 0; i < elements.length ; i++) {
            for (int j = i + 1; j < elements.length; j++) {
                if(elements[i].compare(elements[j]) > 0) {
                    // swap
                    IComparable temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }
    }
}
