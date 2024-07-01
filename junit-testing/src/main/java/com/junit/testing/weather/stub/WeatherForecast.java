package com.junit.testing.weather.stub;

import com.junit.testing.weather.stub.Temperatures;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateAvg() {
        double sum = 0;
        for (Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet())
            sum += temperature.getValue();
        return sum / temperatures.getTemperatures().size();
    }

    public double calculateMedian() {
        List<Double> mapValues = new ArrayList<>();
        for (Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()) {
            mapValues.add(temperature.getValue());
        }
        Collections.sort(mapValues);
        int mid = mapValues.size() / 2;
        if (mapValues.size() % 2 != 0) {
            return mapValues.get(mid);
        } else {
            return (mapValues.get(mid) + mapValues.get(mid - 1)) / 2;
        }
    }

}