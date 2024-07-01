package com.junit.testing.collection;

import java.util.Iterator;
import java.util.*;

public class OddNumbersExterminator {
    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();

        Iterator<Integer> iter = numbers.iterator();
        while(iter.hasNext()) {
            Integer number = iter.next();
            if(number % 2 == 0)
                result.add(number);
        }
        return result;
    }
}