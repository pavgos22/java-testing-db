package com.junit.testing.shapes;

public class Square implements Shape {
    double a;
    String name = "square";

    public Square(double a) {
        this.a = a;
    }

    public void getName() {
        System.out.println("I'm a " + this.name + "!");
    }

    public double getArea() {
        return a*a;
    }
}
