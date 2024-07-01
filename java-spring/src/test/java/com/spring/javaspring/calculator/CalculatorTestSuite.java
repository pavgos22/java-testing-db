package com.spring.javaspring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void testCalculations() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-1, calculator.sub(2, 3));
        assertEquals(6, calculator.mul(2, 3));
        assertEquals(2, calculator.div(6, 3));
    }
}
