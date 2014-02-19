
package com.eubumper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import persistance.MongoStore;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/monitor")
public class MonitorServices {
	MongoStore ms = new MongoStore();
  
    @GET 
    @Produces("text/plain")
    @Path("/ping")
    public String ping(@Context HttpServletRequest request,
			@Context HttpServletResponse response
			) {
    	
    	return "pong - " + request.getRemoteUser();
    }
   
}
