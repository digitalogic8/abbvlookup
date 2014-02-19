package com.eubumper;


import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;
 
/**
 * REST Basic Authentication Client Application
 *
 * @author John Yeary
 * @version 1.0
 */
public class MainClassToAccessService {
 
    public static void main(String[] args) {
        ExampleResourceClient erc = new ExampleResourceClient();
        erc.setUsernamePassword("mike", "f00cbed7");
        System.out.println(erc.getMessage());
        erc.close();
    }
 
    static class ExampleResourceClient {
 
        private com.sun.jersey.api.client.WebResource webResource;
        private com.sun.jersey.api.client.Client client;
        private static final String BASE_URI = "http://localhost:8080/bumperservices/webresources/abbvServices/";
 
        public ExampleResourceClient() {
            com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
            client = com.sun.jersey.api.client.Client.create(config);
            client.addFilter(new LoggingFilter());
            webResource = client.resource(BASE_URI).path("ping");
        }
 
        public String getMessage() throws com.sun.jersey.api.client.UniformInterfaceException {
            WebResource resource = webResource;
            return resource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
        }
 
        public void putMessage(Object requestEntity) throws com.sun.jersey.api.client.UniformInterfaceException {
            webResource.type(javax.ws.rs.core.MediaType.TEXT_PLAIN).put(requestEntity);
        }
 
        public void close() {
            client.destroy();
        }
 
        public void setUsernamePassword(String username, String password) {
            client.addFilter(new com.sun.jersey.api.client.filter.HTTPBasicAuthFilter(username, password));
        }
    }
}
