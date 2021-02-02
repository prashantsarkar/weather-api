package com.prashant.weatherapi.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.prashant.weatherapi.exception.handler.WeatherForecastNotFoundException;
import com.prashant.weatherapi.model.WeatherRoot;
import com.prashant.weatherapi.service.WeatherAPIService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WeatherAPIServiceImpl implements WeatherAPIService {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Value("${weather.api.url}")
    private String apiUrl;
	
	@Value("${weather.api.key}")
	private String key;


    @Override
    public WeatherRoot getWeatherForecast(Long zipcode) {

        log.info("Getting Weather forecast for Zipcode :: {}", zipcode);

        String api = String.format(apiUrl, zipcode, key);
        WeatherRoot response = restTemplate.getForObject(api, WeatherRoot.class);
        log.info("Weather forecast for Zipcode {} is :: {}", zipcode, response);

        if (Objects.isNull(response) || CollectionUtils.isEmpty(response.getList())) {
            throw new WeatherForecastNotFoundException("Weather forecast for tomorrow not found for zipcode :: " + zipcode);
        }

        return response;
    }

}
