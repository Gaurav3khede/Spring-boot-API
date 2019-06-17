package com.tinkhede.backendapi.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tinkhede.backendapi.google.map.models.GoogleMapAPIDataModel;
import com.tinkhede.backendapi.google.map.models.LocationModel;
import com.tinkhede.backendapi.here.we.go.models.HereWeGoDataModel;
import com.tinkhede.backendapi.here.we.go.models.Location;
import com.tinkhede.backendapi.here.we.go.models.Response;
import com.tinkhede.backendapi.here.we.go.models.Result;
import com.tinkhede.backendapi.here.we.go.models.View;
import com.tinkhede.backendapi.open.weather.map.models.OpenWeatherMapDataModel;

/**
 * Service class which is responsible to get data from different APIs
 * @author Gaurav
 *
 */
@Service
@Configuration
@PropertySource("classpath:config.properties")
public class WeatherAndCoordinatesService {
	@Autowired
	RestTemplate restTemplate;

	@Value("${googleMapUrl}")
	private String googleMapUrl;
	@Value("${hereWoGoUrl}")
	private String hereWoGoUrl;
	@Value("${openStreetMapUrl}")
	private String openStreetMapUrl;
	@Value("${openWeatherMapUrl}")
	private String openWeatherMapUrl;
	
	/**
	 * Method to get Coordinates from Google Map API
	 * @param cityName
	 * @param googleMapKey
	 * @return
	 */
	public LocationModel getCoordinatesFromGoogleMap(String cityName,String googleMapKey) {

		String url = googleMapUrl + googleMapKey + "&address=" +cityName;
		GoogleMapAPIDataModel googleMapAPIDataModel = restTemplate.getForObject(url ,
				GoogleMapAPIDataModel.class);

		if (!googleMapAPIDataModel.getResults().isEmpty()) {
			return googleMapAPIDataModel.getResults().get(0).getGeometry().getLocation();
		}
		return null;

	}
	/**
	 * Method to get Coordinates from Here We Go API
	 * @param cityName
	 * @param hereWeGoAppId
	 * @param hereWeGoAppCode
	 * @return
	 */
	public LocationModel getCoordinatesFromHereWeGo(String cityName,String hereWeGoAppId,String hereWeGoAppCode) {

		LocationModel locationModel = new LocationModel();

		String url = hereWoGoUrl + cityName +"&app_id="+hereWeGoAppId+"&app_code="+hereWeGoAppCode;
		HereWeGoDataModel hereWeGoDataModel = restTemplate.getForObject(url, HereWeGoDataModel.class);

		Response response = hereWeGoDataModel.getResponse();
		View[] views = response.getView();
		if (views.length != 0) {
			Result[] results = views[0].getResult();
			Location location = results[0].getLocation();

			locationModel.setLat(Double.valueOf(location.getDisplayPosition().getLatitude()));
			locationModel.setLng(Double.valueOf(location.getDisplayPosition().getLongitude()));

			return locationModel;
		}
		return null;
	}

	/**
	 * Method to get coordinates from Open Street Map API
	 * @param cityName
	 * @return
	 */
	public LocationModel getCoordinatesFromOpenStreetMap(String cityName) {
		LocationModel locationModel = new LocationModel();
		List<Map> data = restTemplate.getForObject(openStreetMapUrl + cityName + "?&limit=1&format=json", List.class);
		if (!data.isEmpty()) {
			locationModel.setLat(Double.valueOf(data.get(0).get("lat").toString()));
			locationModel.setLng(Double.valueOf(data.get(0).get("lon").toString()));
			return locationModel;
		}
		return null;
	}
	/**
	 * Method to get weather Details from Open Weather Map API
	 * @param cityName
	 * @param openWeatherMapAppId
	 * @return
	 */
	public OpenWeatherMapDataModel getWeatherDetailsFromOpenWeatherMap(String cityName,String openWeatherMapAppId) {

		String url = openWeatherMapUrl + cityName + "&appid=" + openWeatherMapAppId;
		return restTemplate.getForObject(url, OpenWeatherMapDataModel.class);

	}

	/**
	 * Method to calculate center point of city from multiple coordinates of city
	 * @param coordinates
	 * @return
	 */
	public LocationModel calculateCenterPoint(List<LocationModel> coordinates) {

		double avgX = 0;
		double avgY = 0;
		double avgZ = 0;
		for (LocationModel point : coordinates) {
			double lat = Math.toRadians(point.getLat());
			double lon = Math.toRadians(point.getLng());

			double x = Math.cos(lat) * Math.cos(lon);
			double y = Math.cos(lat) * Math.sin(lon);
			double z = Math.sin(lat);

			avgX += x;
			avgY += y;
			avgZ += z;
		}

		avgX /= coordinates.size();
		avgY /= coordinates.size();
		avgZ /= coordinates.size();

		double averageLon = Math.atan2(avgY, avgX);
		double hyp = Math.sqrt(avgX * avgX + avgY * avgY);
		double averageLat = Math.atan2(avgZ, hyp);

		return new LocationModel(Math.toDegrees(averageLat), Math.toDegrees(averageLon));
	}

}
