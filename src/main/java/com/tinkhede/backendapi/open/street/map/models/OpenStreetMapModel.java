package com.tinkhede.backendapi.open.street.map.models;

import java.util.List;

public class OpenStreetMapModel {
	
	private List<OpenStreetMapDataModel> openStreetMapData ;

	public List<OpenStreetMapDataModel> getOpenStreetMapData() {
		return openStreetMapData;
	}

	public void setOpenStreetMapData(List<OpenStreetMapDataModel> openStreetMapData) {
		this.openStreetMapData = openStreetMapData;
	}

}
