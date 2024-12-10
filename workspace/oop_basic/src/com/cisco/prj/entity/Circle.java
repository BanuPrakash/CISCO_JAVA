package com.cisco.prj.entity;

import com.cisco.prj.util.IComparable;

public class Circle implements IComparable {
    private int radius;

    public Circle() {
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public int compare(Object other) {
        Circle c = (Circle) other;
        return this.radius - c.radius;
    }
}
