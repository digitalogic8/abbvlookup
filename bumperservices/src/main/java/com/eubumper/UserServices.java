
package com.eubumper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.codehaus.jettison.json.JSONObject;

import com.eubumper.util.ServiceReturnObject;
import com.eubumper.util.ServiceStatus;
import com.google.gson.JsonObject;

import persistance.MongoStore;
import bumperdata.User;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/user")
public class UserServices {
	MongoStore ms = new MongoStore();
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET 
    @Produces("application/json")
    @Path("/registerUser")
    public String registerUser(@Context HttpServletRequest request,
			@Context HttpServletResponse response,
			@QueryParam("username") String username,
			@QueryParam("password") String password,
			@QueryParam("email") String email,
			@QueryParam("firstname") String firstname,
			@QueryParam("lastname") String lastname,
			@QueryParam("phonenumber") String phonenumber,
			@QueryParam("company") String company) {
    	User s = ms.findUser(username);
    	if(s!=null)
    	  return new ServiceReturnObject(ServiceStatus.ERROR, "Username already registered", null).toString();
        User u = new User(username,password,email,firstname,lastname,phonenumber,company);
        String message = ms.storeObject("User", u.toString());
        if(message.equalsIgnoreCase("success")){
    	 return new ServiceReturnObject(ServiceStatus.OK, "User " + username + " has been registered.", null).toString();
        } else {
        	 JsonObject error = new JsonObject();
        	 error.addProperty("error", message);
        	 return new ServiceReturnObject(ServiceStatus.ERROR, "Error storing user in db.", error).toString();
             
        }
    }

    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET 
    @Produces("application/json")
    @Path("/findUser")
    public String findUser(@Context HttpServletRequest request,
			@Context HttpServletResponse response,
			@QueryParam("username") String username) {
    	User s = ms.findUser(username);
    	if(s!=null)
    		return new ServiceReturnObject(ServiceStatus.ERROR, "Error storing user in db.", s.toJSON()).toString();
    	else
    		return new ServiceReturnObject(ServiceStatus.ERROR, "User does not exist", null).toString();
        
    }


}
