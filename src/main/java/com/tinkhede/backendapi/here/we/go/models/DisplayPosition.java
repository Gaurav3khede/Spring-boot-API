
package com.tinkhede.backendapi.here.we.go.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisplayPosition
{
	 @JsonProperty("Latitude")
    private String latitude;
	 @JsonProperty("Longitude")
    private String longitude;

    public String getLatitude ()
    {
        return latitude;
    }

    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }

    public String getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Latitude = "+latitude+", Longitude = "+longitude+"]";
    }
}
		