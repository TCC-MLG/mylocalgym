package br.com.gym.mylocalgym.resource;

import br.com.gym.mylocalgym.parameter.ClienteParameter;
import br.com.gym.mylocalgym.entities.Cliente;
import br.com.gym.mylocalgym.parameter.AlterarClienteParameter;
import br.com.gym.mylocalgym.presenters.DadosClientePresenter;
import br.com.gym.mylocalgym.service.ClienteService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;
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
    public Response cadastrarCliente(ClienteParameter cliente) {

        Boolean cadastrado = this.clienteService.cadastrarCliente(new Cliente(cliente));

        return cadastrado ? ok().build() : status(Response.Status.BAD_REQUEST).build();

    }

    @PUT
    @Path("{clienteId}/alterar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response alterarCliente(@PathParam("clienteId") Integer clienteId, AlterarClienteParameter clienteParameter) {

        boolean alterado = this.clienteService.alterarCliente(clienteId, clienteParameter);

        return alterado ? ok().build() : status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("{clienteId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarClientePorId(@PathParam("clienteId") Integer clienteId) {

        Cliente cliente = this.clienteService.buscarClientePorId(clienteId);
        
        return cliente != null ? ok(new DadosClientePresenter(cliente)).build() : status(NO_CONTENT).build();
    }
}
