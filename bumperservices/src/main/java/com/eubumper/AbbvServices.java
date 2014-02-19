
package com.eubumper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import persistance.MongoStore;
import bumperdata.Abbreviation;
import bumperdata.Registration;
import bumperdata.User;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/abbv")
public class AbbvServices {
	MongoStore ms = new MongoStore();

    @GET 
    @Produces("text/plain")
    @Path("/registerAbbv")
    public String registerUser(@Context HttpServletRequest request,
			@Context HttpServletResponse response,
			@QueryParam("abbv") String abbv,
            @QueryParam("registered") String registered,
            @QueryParam("expiration") String expiration) {
    	User s = ms.findUser(request.getRemoteUser());
        Abbreviation abbv_obj = ms.findAbbreviation(abbv);
    	//Should registrations store the actual object User, the ID or something else?
        Registration u = new Registration(abbv_obj, s, new Date(), new Date());
        String message = ms.storeObject("Registration", u.toString());
    	return message;
    }
    @GET 
    @Produces("text/plain")
    @Path("/lookupAbbv")
    public String lookup(@Context HttpServletRequest request,
			@Context HttpServletResponse response,
			@QueryParam("abbv") String abbv) {
        Abbreviation abbv_obj = ms.findAbbreviation(abbv);
    	return abbv_obj.toString();
    }
}
