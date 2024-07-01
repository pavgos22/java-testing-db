package com.junit.testing.shapes;

public class Triangle implements Shape {
    double a, h;
    String name = "triangle";

    public Triangle(double a, double h) {
        this.a = a;
        this.h = h;
    }

    public void getName() {
        System.out.println("I'm a " + this.name + "!");
    }

    public double getArea() {
        return a*h/2;
    }
}
