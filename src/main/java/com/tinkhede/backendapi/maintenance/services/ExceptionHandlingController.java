package com.tinkhede.backendapi.maintenance.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.tinkhede.backendapi.maintenance.models.CityNotFoundException;
import com.tinkhede.backendapi.maintenance.models.ExceptionResponse;
/**
 * Controller which handles exceptions in API
 * @author Gaurav
 *
 */
@ControllerAdvice
public class ExceptionHandlingController { 	
	
/**
 * Method which takes care of Exception other than CityNotFoundException.
 * @param e
 * @return
 * @throws Exception
 */
	@ExceptionHandler(Exception.class)
	  public ResponseEntity<ExceptionResponse>generalException(Exception e) throws Exception{
		  
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		exceptionResponse.setDescription(e.getMessage());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	
	/**
	 * Method which takes care of CityNotFoundException.
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(CityNotFoundException.class)
	  public ResponseEntity<ExceptionResponse>specialException(CityNotFoundException e) throws Exception{
		  
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setCode(HttpStatus.BAD_REQUEST.value());
		exceptionResponse.setDescription(e.getMessage());
		
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.BAD_REQUEST);
	  }
	
}
