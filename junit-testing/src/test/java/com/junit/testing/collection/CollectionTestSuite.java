package com.junit.testing.collection;

import com.junit.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {
    OddNumbersExterminator even = new OddNumbersExterminator();
    List<Integer> emptyList = new ArrayList<>();
    List<Integer> normalList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName("when create List no elements, " +
            "then List.toString() should return nothing"
    )

    @Test
    void testOddNumbersExterminatorEmptyList(){
        Assertions.assertTrue(even.exterminate(emptyList).isEmpty());
    }

    @DisplayName("when create List with odd and even numbers, " +
            "then List.toString() should return only even values"
    )

    @Test
    void testOddNumbersExterminatorNormalList() {
        List<Integer> result = even.exterminate(normalList);
        List<Integer> expectedList = Arrays.asList(0, 2, 4, 6, 8);
        Assertions.assertEquals(result, expectedList);
    }
}