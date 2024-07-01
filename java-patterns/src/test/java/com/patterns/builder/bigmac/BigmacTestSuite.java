package com.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    public void testBigmacBuilder() {
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("With sesame")
                .burgers(2)
                .sauce("Barbecue")
                .ingredient("Onion")
                .ingredient("Bacon")
                .ingredient("Cheese")
                .build();

        int numberOfIngredients = bigmac.getIngredients().size();

        assertEquals("With sesame", bigmac.getBun());
        assertEquals(2, bigmac.getBurgers());
        assertEquals("Barbecue", bigmac.getSauce());
        assertEquals(3, numberOfIngredients);
    }
}
