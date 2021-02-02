package com.prashant.weatherapi.model.response;


import java.io.Serializable;

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
public class WeatherAPIResponseWrapper implements Serializable {

	private static final long serialVersionUID = 3551190286266169339L;
	private int code;
	private String message;
	private WeatherAPIResponse weatherAPIResponse;
}
