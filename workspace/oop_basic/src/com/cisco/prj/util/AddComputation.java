package com.cisco.prj.util;

// concrete class
public class AddComputation implements Computation{

    @Override
    public int compute(int x, int y) {
        return x + y;
    }
}
