
package com.tinkhede.backendapi.here.we.go.models;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * This is a placeholder model which contains data fetched from Here We Go API
 * @author Gaurav
 *
 */
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
		
