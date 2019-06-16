package com.tinkhede.backendapi.models;

import com.tinkhede.backendapi.google.map.models.LocationModel;

public class CoordinatesAndWeatherInfoModel {
	
	private LocationModel centerPointOfCity;
	
	private WeatherInformation weatherInformation;

	/*
	 * private OpenWeatherMapDataModel openWeatherMapDataModel;
	 * 
	 * public OpenWeatherMapDataModel getOpenWeatherMapDataModel() { return
	 * openWeatherMapDataModel; }
	 * 
	 * public void setOpenWeatherMapDataModel(OpenWeatherMapDataModel
	 * openWeatherMapDataModel) { this.openWeatherMapDataModel =
	 * openWeatherMapDataModel; }
	 */


	public WeatherInformation getWeatherInformation() {
		return weatherInformation;
	}

	public void setWeatherInformation(WeatherInformation weatherInformation) {
		this.weatherInformation = weatherInformation;
	}

	public LocationModel getCenterPointOfCity() {
		return centerPointOfCity;
	}

	public void setCenterPointOfCity(LocationModel centerPointOfCity) {
		this.centerPointOfCity = centerPointOfCity;
	}

}
