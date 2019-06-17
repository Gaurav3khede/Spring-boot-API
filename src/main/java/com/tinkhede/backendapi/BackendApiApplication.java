package com.tinkhede.backendapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/**
 * 
 * @author Gaurav
 *
 */
@SpringBootApplication
public class BackendApiApplication {
    /**
     * Method which starts spring application
     * @param args
     */
	public static void main(String[] args) {
		SpringApplication.run(BackendApiApplication.class, args);
	}
	/**
	 * This method returns singleton RestTemplate object
	 * @return
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		
		return new RestTemplate();
	}

}
