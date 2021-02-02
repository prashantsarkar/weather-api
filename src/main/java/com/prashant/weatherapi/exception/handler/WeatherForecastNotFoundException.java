package com.prashant.weatherapi.exception.handler;

/**
 * @author Prashant Sarkar
 *
 */
public class WeatherForecastNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public WeatherForecastNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}