package com.prashant.weatherapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Prashant Sarkar
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherRoot implements Serializable {
	private static final long serialVersionUID = 8493160397745645281L;
	private String cod;
    private int message;
    private int cnt;
    private List<ListData> list;
    private City city;
}