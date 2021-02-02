package com.prashant.weatherapi.service;

import com.prashant.weatherapi.model.response.WeatherAPIResponseWrapper;

/**
 * @author Prashant Sarkar
 *
 */
public interface WeatherAPIService {

	WeatherAPIResponseWrapper getWeatherForecast(Long zipCode);
}
