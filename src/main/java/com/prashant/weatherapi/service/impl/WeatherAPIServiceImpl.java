package com.prashant.weatherapi.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.prashant.weatherapi.exception.handler.WeatherForecastNotFoundException;
import com.prashant.weatherapi.model.ListData;
import com.prashant.weatherapi.model.WeatherRoot;
import com.prashant.weatherapi.model.response.WeatherAPIResponse;
import com.prashant.weatherapi.model.response.WeatherAPIResponseWrapper;
import com.prashant.weatherapi.service.WeatherAPIService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Prashant Sarkar
 *
 */
@Slf4j
@Service
public class WeatherAPIServiceImpl implements WeatherAPIService {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Value("${weather.api.url}")
    private String apiUrl;
	
	@Value("${weather.api.key}")
	private String key;
	
	@HystrixCommand(fallbackMethod = "getWeatherForecastFallBack")
    @Override
    public WeatherAPIResponseWrapper getWeatherForecast(Long zipcode) {

        log.info("Getting Weather forecast for Zipcode :: {}", zipcode);

        String api = String.format(apiUrl, zipcode, key);
        WeatherRoot response = restTemplate.getForObject(api, WeatherRoot.class);
        log.info("Weather forecast for Zipcode {} is :: {}", zipcode, response);
        
        WeatherAPIResponse weatherAPIResponse = WeatherAPIResponse.builder()
                .cityName(response.getCity().getName())
                .country(response.getCity().getCountry())
                .wetherForecast(getTomorrowsPredictedData(response.getList()))
                .zipcode(zipcode)
                .build();
        
        if (Objects.isNull(response) || CollectionUtils.isEmpty(response.getList())) {
            throw new WeatherForecastNotFoundException("Weather forecast for tomorrow not found for zipcode :: " + zipcode);
        }

        return WeatherAPIResponseWrapper.builder()
        		.code(HttpStatus.OK.value())
        		.message(HttpStatus.OK.name())
        		.weatherAPIResponse(weatherAPIResponse)
        		.build();
    }
	
	public WeatherAPIResponseWrapper getWeatherForecastFallBack(Long zipcode) {

        log.info("Fallback forecast for Zipcode :: {}", zipcode);

        return WeatherAPIResponseWrapper.builder()
        		.code(HttpStatus.TEMPORARY_REDIRECT.value())
        		.message(HttpStatus.TEMPORARY_REDIRECT.name())
        		.weatherAPIResponse(
        				WeatherAPIResponse.builder()
        				.cityName("Dummy")
        				.country("Dummy")
        				.wetherForecast(new HashMap<>())
        				.build()
        		).build();
    }
	
	private Map<String, Double> getTomorrowsPredictedData(List<ListData> list) {

        log.info("Populating Weather forecast for tomorrow");

        Map<String, Double> hourlyTemperature = new HashMap<>();
        LocalDate tomorrowsLocalDate = LocalDate.now().plusDays(1);

        list.forEach(listData -> {
            if (tomorrowsLocalDate.getDayOfMonth() == Integer.parseInt(listData.getDt_txt().substring(8, 10))) {
            	hourlyTemperature.put(listData.getDt_txt(), listData.getMain().getTemp_min());
            }
        });

        log.info("Populated Weather forecast for tomorrow");

        return hourlyTemperature;
    }

}
