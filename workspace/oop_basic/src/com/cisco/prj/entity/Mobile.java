package com.cisco.prj.entity;

import java.util.function.Predicate;

// Mobile inherits Product
// state and behaviour are inherited
// constructors are not inherited
public class Mobile extends Product{
    private String connectivity;

    public Mobile() {
    }

    public Mobile(int id, String name, double price, String connectivity) {
        super(id, name, price); // call - chain to Product constructor
        this.connectivity = connectivity;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(String connectivity) {
        this.connectivity = connectivity;
    }

    // already behaviour exists in base class
    // we redefine the  behaviour
    @Override
    public boolean isExpensive() {
       if("3G".equals(connectivity) && getPrice() > 3000) {
           return  true;
       } else if ("4G".equals(connectivity) && getPrice() > 15_000) {
           return  true;
       } else if( "5G".equals(connectivity) && getPrice() > 40_000) {
           return  true;
       }
       return  false;
    }
}
