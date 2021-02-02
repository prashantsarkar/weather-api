package com.prashant.weatherapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Prashant Sarkar
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wind implements Serializable {
	private static final long serialVersionUID = -2757864561088461402L;
	private double speed;
    private int deg;
}