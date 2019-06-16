
package com.tinkhede.backendapi.here.we.go.models;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response
{
    @JsonProperty("View")
    private View[] view;

    @Override
    public String toString()
    {
        return "ClassPojo  View = "+view+"]";
    }

	public View[] getView() {
		return view;
	}

	public void setView(View[] view) {
		this.view = view;
	}
}
			
