package com.tinkhede.backendapi.models;

public class WeatherInformation {

	private String temperature;
	private String weatherReport;
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getWeatherReport() {
		return weatherReport;
	}
	public void setWeatherReport(String weatherReport) {
		this.weatherReport = weatherReport;
	}
}
