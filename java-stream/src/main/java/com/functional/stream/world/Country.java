package com.functional.stream.world;

import java.math.BigDecimal;

public class Country {
    private BigDecimal peopleQuantity;
    private String name;

    public Country(BigDecimal peopleQuantity) {
        this.peopleQuantity = peopleQuantity;
    }

    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }
}
