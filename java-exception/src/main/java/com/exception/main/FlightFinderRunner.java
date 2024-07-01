package com.exception.main;

import com.exception.test.Flight;
import com.exception.test.FlightSearch;
import com.exception.test.RouteNotFoundException;

public class FlightFinderRunner {
    public static void main(String[] args) {
        Flight flightToBerlin = new Flight("Warsaw", "Berlin");
        Flight flightToParis = new Flight("Warsaw", "Paris");
        Flight flightToUnknown = new Flight("Warsaw", "Madrid");

        FlightSearch flightSearch = new FlightSearch();

        try {
            boolean isFlightToBerlinAvailable = flightSearch.findFlight(flightToBerlin);
            System.out.println("Flight to Berlin available: " + isFlightToBerlinAvailable);

            boolean isFlightToParisAvailable = flightSearch.findFlight(flightToParis);
            System.out.println("Flight to Paris available: " + isFlightToParisAvailable);

            boolean isFlightToUnknownAvailable = flightSearch.findFlight(flightToUnknown);
            System.out.println("Flight to Unknown available: " + isFlightToUnknownAvailable);

        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}