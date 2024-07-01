package com.functional.stream.world;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {

        Country poland = new Country(new BigDecimal("38000000"));
        Country germany = new Country(new BigDecimal("83000000"));
        Country belgium = new Country(new BigDecimal("11000000"));

        Country china = new Country(new BigDecimal("1412000000"));
        Country india = new Country(new BigDecimal("1408000000"));
        Country bangladesh = new Country(new BigDecimal("16900000"));


        Continent europe = new Continent();
        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(belgium);

        Continent asia = new Continent();
        asia.addCountry(china);
        asia.addCountry(india);
        asia.addCountry(bangladesh);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);

        BigDecimal totalPopulation = world.getPeopleQuantity();
        assertEquals(new BigDecimal("2968900000"), totalPopulation);
    }
}