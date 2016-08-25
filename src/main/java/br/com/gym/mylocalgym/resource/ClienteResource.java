package br.com.gym.mylocalgym.resource;

import br.com.gym.mylocalgym.service.ClienteService;
import entities.Cliente;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;

/**
 * @author Matheus
 */
@Path("/cliente")
public class ClienteResource {

    @Inject
    private ClienteService clienteService;

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarCliente(Cliente cliente) {

        Boolean cadastrado = this.clienteService.cadastrarCliente(cliente);
        
        return cadastrado == true ? ok().build() : status(Response.Status.BAD_REQUEST).build();
    }

}
