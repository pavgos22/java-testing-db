package com.junit.testing.shapes;

public class Circle implements Shape {
    double r;
    String name = "circle";

    public Circle(double r) {
        this.r = r;
    }

    public void getName() {
        System.out.println("I'm a " + this.name + "!");
    }

    public double getArea() {
        return Math.PI*r*r;
    }
}
