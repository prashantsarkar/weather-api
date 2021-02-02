package com.prashant.weatherapi.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Prashant Sarkar
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather implements Serializable {
	private static final long serialVersionUID = -5166680522400991687L;
	private int id;
    private String main;
    private String description;
    private String icon;
}