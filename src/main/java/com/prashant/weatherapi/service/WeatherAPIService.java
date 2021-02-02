package com.prashant.weatherapi.service;

import com.prashant.weatherapi.model.WeatherRoot;

/**
 * @author Prashant Sarkar
 *
 */
public interface WeatherAPIService {

	WeatherRoot getWeatherForecast(Long zipCode);
}
