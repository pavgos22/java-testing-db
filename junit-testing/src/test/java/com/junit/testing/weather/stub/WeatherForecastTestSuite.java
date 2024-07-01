package com.junit.testing.weather.stub;

import com.junit.testing.weather.stub.Temperatures;
import com.junit.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeatherForecastTestSuite {

    @Test
    void testCalculateForecastWithStub() {
        //Given
        Temperatures temperatures = new TemperaturesStub();                     // [1]
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);    // [2]

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }
}