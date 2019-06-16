
package com.tinkhede.backendapi.here.we.go.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class View
{
   
    @JsonProperty("Result")
    private Result[] result;

    public Result[] getResult ()
    {
        return result;
    }

    public void setResult (Result[] result)
    {
        this.result = result;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ Result = "+result+"]";
    }
}
			
			
