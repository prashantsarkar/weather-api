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
public class Sys implements Serializable {
	private static final long serialVersionUID = 6668855669521700382L;
	private String pod;
}
