package com.tinkhede.backendapi.maintenance.models;

import org.springframework.stereotype.Component;
/**
 * Custom Exception class to handle situation when city is not found.
 * @author Gaurav
 *
 */
@Component
public class CityNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int code;

	private String message;

	public CityNotFoundException() {

	}
	/**
	 * Parameterized constructor
	 * @param code
	 * @param message
	 */
	public CityNotFoundException(int code, String message) {

		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
