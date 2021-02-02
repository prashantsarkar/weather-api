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
public class Coord implements Serializable {
	private static final long serialVersionUID = -6646280440225596011L;
	private double lat;
    private double lon;
}