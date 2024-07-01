package com.junit.testing.shapes;

import java.util.ArrayList;

public class ShapeCollector {
    public ArrayList<Shape> shapeList = new ArrayList<>();

    public void addFigure(Shape s) {
        shapeList.add(s);
    }

    public void removeShape(Shape s) {
        shapeList.remove(s);
    }

    public Shape getFigure(Shape s) {
        if (shapeList.contains(s))
            return s;
        return null;
    }

    public ArrayList<Shape> showFigures() {
        return shapeList;
    }

    public void removeFigure(Shape shape) {
        shapeList.remove(shape);
    }
}
