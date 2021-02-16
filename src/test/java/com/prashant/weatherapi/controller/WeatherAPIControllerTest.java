package com.prashant.weatherapi.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.prashant.weatherapi.exception.handler.InvalidZipcodeException;
import com.prashant.weatherapi.model.response.WeatherAPIResponseWrapper;
import com.prashant.weatherapi.service.WeatherAPIService;

@SpringBootTest
class WeatherAPIControllerTest {
	@InjectMocks
	private WeatherAPIController controller;

	@Mock
	private WeatherAPIService service;

	@Test
	public void getWeatherForecastZipcodeSuccessTest() {

		WeatherAPIResponseWrapper weatherAPIResponseWrapper = WeatherAPIResponseWrapper.builder().build();

		when(service.getWeatherForecast(anyLong())).thenReturn(weatherAPIResponseWrapper);
		ResponseEntity<WeatherAPIResponseWrapper> responseEntity = controller.getWeatherForecastZipcode("12345");

		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void getWeatherForecastZipcodeFailureForLessThanFiveLengthTest() {
		Assertions.assertThrows(InvalidZipcodeException.class, () -> {
			controller.getWeatherForecastZipcode("1234");
		});
	}
	
	@Test
	public void getWeatherForecastZipcodeFailureForGreaterThanFiveLengthTest() {
		Assertions.assertThrows(InvalidZipcodeException.class, () -> {
			controller.getWeatherForecastZipcode("123456");
		});
	}
	
	@Test
	public void getWeatherForecastZipcodeFailureForNullTest() {
		Assertions.assertThrows(InvalidZipcodeException.class, () -> {
			controller.getWeatherForecastZipcode(null);
		});
	}
	
	@Test
	public void getWeatherForecastZipcodeFailureForEmptyStringTest() {
		Assertions.assertThrows(InvalidZipcodeException.class, () -> {
			controller.getWeatherForecastZipcode("");
		});
	}
}
