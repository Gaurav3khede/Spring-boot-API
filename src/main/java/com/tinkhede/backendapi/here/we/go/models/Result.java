
package com.tinkhede.backendapi.here.we.go.models;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result
{
    @JsonProperty("Location")
    private Location location;



    public Location getLocation ()
    {
        return location;
    }

    public void setLocation (Location location)
    {
        this.location = location;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Location = "+location+"]";
    }
}

