package com.functional.stream.array;

import org.junit.jupiter.api.Test;
import java.util.OptionalDouble;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void ArrayOperationsTestSuite() {
        int[] grades = {1, 2, 6, 5, 3, 4, 2, 4, 3, 6, 6, 5, 1, 2, 4, 6, 2, 1, 3, 6};

        OptionalDouble avg = ArrayOperations.getAverage(grades);

        OptionalDouble expextedResult = OptionalDouble.of(3.6);
        assertEquals(expextedResult, avg);
    }

}
