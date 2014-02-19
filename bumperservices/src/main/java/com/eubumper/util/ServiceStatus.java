package com.eubumper.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public enum ServiceStatus {
    OK ("OK"),
    ERROR   ("ERROR");
    
    String message = "";
    
	ServiceStatus(String message){
		this.message = message;
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		String json = gson.toJson(this);
		return json;
	}
	
	public JsonObject toJSON() {
		JsonParser parser = new JsonParser();
		JsonObject o = (JsonObject)parser.parse(toString());
		return o;
	}
}
