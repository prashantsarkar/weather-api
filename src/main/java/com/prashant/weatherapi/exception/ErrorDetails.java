package com.prashant.weatherapi.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Prashant Sarkar
 *
 */
@AllArgsConstructor
@Getter
public class ErrorDetails {

	private Date timestamp;
	
	private int status;
	
	private String error;
	
	private String message;
	
	private String details;

}