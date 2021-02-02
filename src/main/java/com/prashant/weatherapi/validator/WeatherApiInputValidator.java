package com.prashant.weatherapi.validator;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Prashant Sarkar
 *
 */
@Slf4j
public class WeatherApiInputValidator {
	
	public static boolean isValidZipCode(String zipCode) {
		log.info("Validating zipcode :: {}", zipCode);
		return Objects.isNull(zipCode) || zipCode.trim().length() < 5 || zipCode.trim().length() > 5;
	}
}
