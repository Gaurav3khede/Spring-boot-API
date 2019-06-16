
package com.tinkhede.backendapi.here.we.go.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location
{
	 @JsonProperty("DisplayPosition")
	private DisplayPosition displayPosition;


    public DisplayPosition getDisplayPosition ()
    {
        return displayPosition;
    }

    public void setDisplayPosition (DisplayPosition displayPosition)
    {
        this.displayPosition = displayPosition;
    }


    @Override
    public String toString()
    {
        return "ClassPojo [DisplayPosition = "+displayPosition+"]";
    }
}
			