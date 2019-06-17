package com.tinkhede.backendapi;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tinkhede.backendapi.google.map.models.LocationModel;
import com.tinkhede.backendapi.services.WeatherAndCoordinatesService;
/**
 * 
 * @author Gaurav
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendApiApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private WeatherAndCoordinatesService weatherAndCoordinatesService;

	/**
	 * This method tests that, coordinates are getting returned from Open Street Map API.
	 */
	@Test
	public void getCoordinatesFromOpenStreetMap() {
		LocationModel locationModel = weatherAndCoordinatesService.getCoordinatesFromOpenStreetMap("Helsinki");
		assertNotNull(locationModel);
	}

}
