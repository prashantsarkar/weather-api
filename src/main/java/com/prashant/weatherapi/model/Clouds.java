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
public class Clouds implements Serializable {
	private static final long serialVersionUID = -4814159682820877170L;
	private int all;
}