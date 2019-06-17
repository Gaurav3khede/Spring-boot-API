package com.tinkhede.backendapi.google.map.models;

import java.util.List;
//This is a placeholder model which contains data fetched from Google map API
public class GoogleMapAPIDataModel {
	
	private List<GoogleMapAPIModel> results;
	

	public List<GoogleMapAPIModel> getResults() {
		return results;
	}

	public void setResults(List<GoogleMapAPIModel> results) {
		this.results = results;
	}

}
