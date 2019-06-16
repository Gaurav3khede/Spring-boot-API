
package com.tinkhede.backendapi.here.we.go.models;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HereWeGoDataModel
{
	@JsonProperty("Response")
    private Response response;

   

    public Response getResponse() {
		return response;
	}



	public void setResponse(Response response) {
		this.response = response;
	}



	@Override
    public String toString()
    {
        return "ClassPojo [Response = "+response+"]";
    }
}
		
