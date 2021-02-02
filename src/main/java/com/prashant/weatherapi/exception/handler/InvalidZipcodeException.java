package com.prashant.weatherapi.exception.handler;

/**
 * @author Prashant Sarkar
 *
 */
public class InvalidZipcodeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidZipcodeException(String errorMessage) {
        super(errorMessage);
    }

}
