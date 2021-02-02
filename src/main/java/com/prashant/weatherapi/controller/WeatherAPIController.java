package com.prashant.weatherapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.weatherapi.exception.handler.InvalidZipcodeException;
import com.prashant.weatherapi.model.response.WeatherAPIResponseWrapper;
import com.prashant.weatherapi.service.WeatherAPIService;
import com.prashant.weatherapi.validator.WeatherApiInputValidator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Prashant Sarkar
 *
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class WeatherAPIController {
	
	@Autowired
    private WeatherAPIService weatherAPIService;

    @GetMapping("/{zipCode}")
    public ResponseEntity<WeatherAPIResponseWrapper> getWeatherForecastZipcode(@PathVariable String zipCode) {

        log.info("Getting Weather forecast for zipcode :: {}", zipCode);

        if (WeatherApiInputValidator.isValidZipCode(zipCode)) {
            throw new InvalidZipcodeException("Zipcode should not be null or less/greater than 5 characters");
		}
		
        WeatherAPIResponseWrapper response = weatherAPIService.getWeatherForecast(Long.valueOf(zipCode));
        
        log.info("Weather forecast for zipcode :: {} :: ", zipCode, response);
        
        return ResponseEntity.ok().body(response);
    }
	
}
