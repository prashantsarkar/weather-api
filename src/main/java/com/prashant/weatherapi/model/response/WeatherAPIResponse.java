package com.prashant.weatherapi.model.response;


import java.io.Serializable;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Prashant Sarkar
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherAPIResponse implements Serializable {

	private static final long serialVersionUID = 3551190286266169339L;
	private String cityName;
    private String country;
    private long zipcode;
    private Map<String, Double> wetherForecast;
}
