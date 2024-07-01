package com.junit.testing.weather.mock;

import com.junit.testing.weather.stub.Temperatures;
import com.junit.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    //Given
    Map<String, Double> temperaturesMap = new HashMap<>();
    @BeforeEach
    void setUp() {
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
    }
    @Mock
    private Temperatures temperaturesMock;

    @Test
    void testCalculateForecastWithMock() {
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateAvgWithMock() {
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double avgTemperature = weatherForecast.calculateAvg();

        //Then
        Assertions.assertEquals(25.56, avgTemperature, 0.01);
    }

    @Test
    void testCalculateMedianWithMock() {
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double medTemperature = weatherForecast.calculateMedian();

        //Then
        Assertions.assertEquals(25.5, medTemperature);
    }
}