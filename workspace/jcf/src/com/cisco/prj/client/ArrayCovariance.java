package com.cisco.prj.client;

import java.util.Date;

public class ArrayCovariance {
    public static void main(String[] args) {
        Object[] elems = new String[3]; // covariance

        elems[0] = "Hello";
        elems[1] = "World";

        // not typesafe because of Covariance
        elems[2] = new Date(); // no compilation error; runtime ArrayStoreException
    }
}
