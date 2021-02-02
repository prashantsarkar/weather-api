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
public class Clouds implements Serializable {
	private static final long serialVersionUID = -4814159682820877170L;
	private int all;
}