package com.eubumper.security;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import persistance.MongoStore;
import bumperdata.User;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

public class Authentication implements ContainerRequestFilter{

	@Override
	public ContainerRequest filter(ContainerRequest containerRequest) {
		  //GET, POST, PUT, DELETE, ...
        String method = containerRequest.getMethod();
        // myresource/get/56bCA for example
        String path = containerRequest.getPath(true);
 
        //We do allow wadl to be retrieve
        if(method.equals("GET") && (path.equals("application.wadl") || path.equals("application.wadl/xsd0.xsd"))){
            return containerRequest;
        }
        if(method.equals("GET") && (path.equals("index.jsp") || path.equals("register.jsp") || path.equals("register.jsp"))){
            return containerRequest;
        }
        //Get the authentification passed in HTTP headers parameters
        String auth = containerRequest.getHeaderValue("authorization");
 
        //If the user does not have the right (does not provide any HTTP Basic Auth)
        if(auth == null){
            throw new WebApplicationException(Status.UNAUTHORIZED);
        }
 
        //lap : loginAndPassword
        String[] lap = BasicAuth.decode(auth);
 
        //If login or password fail
        if(lap == null || lap.length != 2){
            throw new WebApplicationException(Status.UNAUTHORIZED);
        }
 
        //DO YOUR DATABASE CHECK HERE (replace that line behind)...
        MongoStore ms = new MongoStore();
        User authentificationResult =  ms.findUser(lap[0]);
        if(authentificationResult == null || !authentificationResult.getPassword().equals(lap[1])){
            throw new WebApplicationException(Status.UNAUTHORIZED);
        }
 
        //TODO : HERE YOU SHOULD ADD PARAMETER TO REQUEST, TO REMEMBER USER ON YOUR REST SERVICE...

        return containerRequest;
	}

}
