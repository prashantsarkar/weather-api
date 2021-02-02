package com.prashant.weatherapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

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