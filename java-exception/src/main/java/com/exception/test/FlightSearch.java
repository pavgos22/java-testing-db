package com.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {
    private Map<String, Boolean> availableFlights = new HashMap<>();

    public FlightSearch() {
        availableFlights.put("Warsaw", true);
        availableFlights.put("Berlin", true);
        availableFlights.put("Paris", false);
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Boolean isAvailable = availableFlights.get(flight.getArrivalAirport());
        if (isAvailable == null) {
            throw new RouteNotFoundException("Route to " + flight.getArrivalAirport() + " not found");
        }
        return isAvailable;
    }
}