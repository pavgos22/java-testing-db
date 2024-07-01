package com.functional.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {
    List<Country> countries = new ArrayList<>();

    public List<Country> getCountries() {
        return countries;
    }

    public void addCountry(Country c) {
        countries.add(c);
    }
}