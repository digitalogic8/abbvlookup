package com.eubumper;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class AbbvServicesTest {

//	@Test
//	public void testRegisterUser() {
//		AbbvServices as = new AbbvServices();
//		as.registerUser(null, null, "mike", "f00cbed7", "digitalogic8@gmail.com", "michael", "wells", "2058213928", "dreams");
//	}
	@Test
	public void testPing(){
		try {
			 
			Client client = Client.create();
	 
			WebResource webResource = client
			   .resource("http://localhost:8080/bumperservices/webresources/abbvServices/ping");
	 
			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);
	 
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
	 
			String output = response.getEntity(String.class);
	 
			System.out.println("Output from Server .... \n");
			System.out.println(output);
	 
		  } catch (Exception e) {
	 
			e.printStackTrace();
	 
		  }
	}

}
