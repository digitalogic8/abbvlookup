package com.eubumper.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ServiceReturnObject {
	private ServiceStatus status;
	private String message;
	private JsonObject queryData;
	
	public ServiceReturnObject(ServiceStatus status, String message, JsonObject queryData){
		this.status = status;
		this.message = message;
		this.queryData = queryData;
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		String json = gson.toJson(this);
		return json;
	}
}
