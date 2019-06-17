package com.tinkhede.backendapi.open.weather.map.models;

import java.util.List;
//This is a placeholder model which contains data fetched from Open weather Map API
public class OpenWeatherMapDataModel {
	
	private String name;
	private List<WeatherInfoModel> weather;
	
	private WeatherModel main;
	
	private LocationModel coord;
	
	private WindModel wind;

	public LocationModel getCoord() {
		return coord;
	}

	public void setCoord(LocationModel coord) {
		this.coord = coord;
	}

	public List<WeatherInfoModel> getWeather() {
		return weather;
	}

	public void setWeather(List<WeatherInfoModel> weather) {
		this.weather = weather;
	}

	public WeatherModel getMain() {
		return main;
	}

	public void setMain(WeatherModel main) {
		this.main = main;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WindModel getWind() {
		return wind;
	}

	public void setWind(WindModel wind) {
		this.wind = wind;
	}

}
