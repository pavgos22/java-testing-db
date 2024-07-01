package com.junit.testing.shape;

import com.junit.testing.shapes.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

@DisplayName("TDD: Shapes Test Suite \uD83D\uDE31")
public class ShapeCollectorTestSuite {

    @Nested
    @DisplayName("Tests for adding shapes")
    class AddShapes {
        private ShapeCollector shapeCollector;
        private Shape shape;

        @BeforeEach
        void setup() {
            shapeCollector = new ShapeCollector();
            shape = new Circle(5);
        }

        @Test
        @DisplayName("should add a shape")
        void shouldAddShape() {
            // Given - setup

            // When
            shapeCollector.addFigure(shape);

            // Then
            Assertions.assertTrue(shapeCollector.shapeList.contains(shape));
        }
    }

    @Nested
    @DisplayName("Tests for removing shapes")
    class RemoveShapes {
        private ShapeCollector shapeCollector;
        private Shape shape;

        @BeforeEach
        void setup() {
            shapeCollector = new ShapeCollector();
            shape = new Square(4);
            shapeCollector.addFigure(shape);
        }

        @Test
        @DisplayName("should remove a shape")
        void shouldRemoveShape() {
            // Given - setup

            // When
            shapeCollector.removeFigure(shape);

            // Then
            Assertions.assertFalse(shapeCollector.shapeList.contains(shape));
        }
    }

    @Nested
    @DisplayName("Tests for getting shapes")
    class GetShapes {
        private ShapeCollector shapeCollector;
        private Shape shape;

        @BeforeEach
        void setup() {
            shapeCollector = new ShapeCollector();
            shape = new Triangle(3, 5);
            shapeCollector.addFigure(shape);
        }

        @Test
        @DisplayName("should return the correct shape")
        void shouldGetShape() {
            // Given - setup

            // When
            Shape retrievedShape = shapeCollector.shapeList.get(0);

            // Then
            Assertions.assertEquals(shape, retrievedShape);
        }

        @Test
        @DisplayName("should not return a shape not added")
        void shouldNotGetNotAddedShape() {
            // Given - setup
            Shape notAddedShape = new Circle(6);

            // When
            boolean isShapePresent = shapeCollector.shapeList.contains(notAddedShape);

            // Then
            Assertions.assertFalse(isShapePresent);
        }
    }

    @Nested
    @DisplayName("Tests for showing shapes")
    class ShowShapes {
        private ShapeCollector shapeCollector;
        private Shape shape1;
        private Shape shape2;

        @BeforeEach
        void setup() {
            shapeCollector = new ShapeCollector();
            shape1 = new Square(5);
            shape2 = new Circle(7);
            shapeCollector.addFigure(shape1);
            shapeCollector.addFigure(shape2);
        }

        @Test
        @DisplayName("should show all shapes")
        void shouldShowAllFigures() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle(2);
            Shape square = new Square(3);
            Shape triangle = new Triangle(3, 5);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);

            // When
            ArrayList<Shape> shapes = shapeCollector.showFigures();

            // Then
            Assertions.assertTrue(shapes.contains(circle));
            Assertions.assertTrue(shapes.contains(square));
            Assertions.assertTrue(shapes.contains(triangle));
        }

    }
}
