package com.prashant.weatherapi.validator;

import java.util.Objects;

/**
 * @author Prashant Sarkar
 *
 */
public class WeatherApiInputValidator {
	
	public static boolean isValidZipCode(String zipCode) {
		return Objects.isNull(zipCode) || zipCode.trim().length() < 5;
	}
}
