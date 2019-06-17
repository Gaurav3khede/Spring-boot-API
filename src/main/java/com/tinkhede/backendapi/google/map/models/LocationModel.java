package com.tinkhede.backendapi.google.map.models;
/**
 * Class which is placeholder for Latitude and Longitude.
 * @author Gaurav
 *
 */
public class LocationModel {
	
	private Double lat ;
	
	private Double lng;
	/**
	 * empty constructor
	 */
	public LocationModel() {
		
	}
    /**
     * Parameterized constructor 
     * @param lat
     * @param lng
     */
	public LocationModel(Double lat, Double lng) {

		this.lat = lat;
		this.lng = lng;
	}
	/**
	 * getter for latitude
	 * @return
	 */
	public Double getLat() {
		return lat;
	}
	/**
	 * setter for latitude
	 * @param lat
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}
	/**
	 * getter for longitude
	 * @return
	 */
	public Double getLng() {
		return lng;
	}
	/**
	 * setter for longitude
	 * @param lng
	 */
	public void setLng(Double lng) {
		this.lng = lng;
	}

	
	
	

}
