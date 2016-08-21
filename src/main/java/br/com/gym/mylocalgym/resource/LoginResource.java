package br.com.gym.mylocalgym.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Matheus
 */
@Path("/login")
public class LoginResource {

    @GET
    @Path("/autenticar")
    @Produces("application/json")
    public boolean autenticar() {

        System.out.println("br.com");
        return true;
    }
    
}
