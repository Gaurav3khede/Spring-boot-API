package com.tinkhede.backendapi.maintenance.models;

import org.springframework.stereotype.Component;
/**
 * Class which is the response to rest client in case of any exception/ error.
 * @author Gaurav
 *
 */
@Component
public class ExceptionResponse {

	private int code ;
	
	private String description;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
