package com.tinkhede.backendapi.services.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tinkhede.backendapi.google.map.models.LocationModel;
import com.tinkhede.backendapi.maintenance.models.CityNotFoundException;
import com.tinkhede.backendapi.models.CoordinatesAndWeatherInfoModel;
import com.tinkhede.backendapi.models.WeatherInformation;
import com.tinkhede.backendapi.open.weather.map.models.OpenWeatherMapDataModel;
import com.tinkhede.backendapi.services.WeatherAndCoordinatesService;

@RestController
@RequestMapping("/")
public class CoordinatesAndWeatherResource {

	@Autowired
	private WeatherAndCoordinatesService weatherAndCoordinatesService;

	@RequestMapping(value = "/backendapi/{cityName}", method = RequestMethod.GET)
	public CoordinatesAndWeatherInfoModel getCoordinatesAndWeatherInfo(@PathVariable("cityName") String cityName,
			@RequestHeader(value="googleMapKey") String googleMapKey,
			@RequestHeader(value="hereWeGoAppId") String hereWeGoAppId,
			@RequestHeader(value="hereWeGoAppCode") String hereWeGoAppCode,
			@RequestHeader(value="openWeatherMapAppId") String openWeatherMapAppId)
			throws CityNotFoundException {

		List<LocationModel> coordinates = new ArrayList<LocationModel>();
		// Google Map
		coordinates.add(weatherAndCoordinatesService.getCoordinatesFromGoogleMap(cityName,googleMapKey));
		
		// Here We go
		coordinates.add(weatherAndCoordinatesService.getCoordinatesFromHereWeGo(cityName,hereWeGoAppId,hereWeGoAppCode));
		// Open Street Map
		coordinates.add(weatherAndCoordinatesService.getCoordinatesFromOpenStreetMap(cityName));
		//remove null from list if all APIs are unable to find the city
		while(coordinates.remove(null));
		if (coordinates.isEmpty()) {
			throw new CityNotFoundException(400, "Sorry city not found");
		}
		// Open Weather Map Model
		OpenWeatherMapDataModel openWeatherMapDataModel = weatherAndCoordinatesService
				.getWeatherDetailsFromOpenWeatherMap(cityName,openWeatherMapAppId);

		// Final return object
		return getCenterPointAndWeatherDetails(weatherAndCoordinatesService,coordinates,openWeatherMapDataModel);
	}
	
	@RequestMapping("/*")
	public void pageNotFound()
			throws CityNotFoundException {
		throw new CityNotFoundException(400, "Invalid URL");
	}
	
	private CoordinatesAndWeatherInfoModel getCenterPointAndWeatherDetails(WeatherAndCoordinatesService weatherAndCoordinatesService,
			List<LocationModel> coordinates,OpenWeatherMapDataModel openWeatherMapDataModel) {
		
		CoordinatesAndWeatherInfoModel coordinatesAndWeatherInfoModel = new CoordinatesAndWeatherInfoModel();
		// calculate center point
		coordinatesAndWeatherInfoModel.setCenterPointOfCity(weatherAndCoordinatesService.calculateCenterPoint(coordinates));
		//coordinatesAndWeatherInfoModel.setOpenWeatherMapDataModel(openWeatherMapDataModel);
		
		String weatherReport = "At the moment,  "+openWeatherMapDataModel.getWeather().get(0).getDescription()+" in "
		+openWeatherMapDataModel.getName()+". The high today will be "+openWeatherMapDataModel.getMain().getTemp_max()+
		 " degrees with the low of "+openWeatherMapDataModel.getMain().getTemp_min()+" degrees this evening.";
		
		WeatherInformation weatherInformation = new WeatherInformation();
		weatherInformation.setTemperature(openWeatherMapDataModel.getMain().getTemp()+" degrees");
		weatherInformation.setWeatherReport(weatherReport);
		coordinatesAndWeatherInfoModel.setWeatherInformation(weatherInformation);

		return coordinatesAndWeatherInfoModel;
		
	}
}
