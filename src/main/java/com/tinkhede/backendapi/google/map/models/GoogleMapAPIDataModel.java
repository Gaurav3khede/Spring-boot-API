package com.tinkhede.backendapi.google.map.models;

import java.util.List;
/**
 * This is a placeholder model which contains data fetched from Google map API
 * @author Gaurav
 *
 */
public class GoogleMapAPIDataModel {
	
	private List<GoogleMapAPIModel> results;
	
    /**
     *  This method returns the list of GoogleMapAPIModel  from google map API
     * @return
     */
	public List<GoogleMapAPIModel> getResults() {
		return results;
	}
    /**
     * setter method for results.
     * @param results
     */
	public void setResults(List<GoogleMapAPIModel> results) {
		this.results = results;
	}

}
