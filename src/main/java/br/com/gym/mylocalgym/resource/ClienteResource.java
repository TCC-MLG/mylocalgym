package br.com.gym.mylocalgym.resource;

import br.com.gym.mylocalgym.parameter.ClienteParameter;
import br.com.gym.mylocalgym.entities.Cliente;
import br.com.gym.mylocalgym.parameter.AlterarClienteParameter;
import br.com.gym.mylocalgym.parameter.AlterarExameParameter;
import br.com.gym.mylocalgym.presenters.DadosClientePresenter;
import br.com.gym.mylocalgym.presenters.ExamePresenter;
import br.com.gym.mylocalgym.service.ClienteService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
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
    @Path("{clienteId}/alterar/exame")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response alterarExame(
            @PathParam("clienteId") Integer clienteId, AlterarExameParameter parameter) {

        boolean atualizado = false;

        if (clienteId != null && parameter != null) {

            Cliente cliente = this.clienteService.buscarClientePorId(clienteId);
            cliente.setExameMedico(parameter.getExame());

            atualizado = this.clienteService.alterarExame(clienteId, cliente);
        }
        return ok(atualizado).build();
    }

    @GET
    @Path("{clienteId}/exame")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarExame(@PathParam("clienteId") Integer clienteId) {

        byte[] exame = null;
        if (clienteId != null) {

            exame = this.clienteService.buscarExame(clienteId);
        }

        return exame != null ? ok(new ExamePresenter(exame)).build() : status(BAD_REQUEST).build();
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarCliente(ClienteParameter cliente) {

        Boolean cadastrado = this.clienteService.cadastrarCliente(new Cliente(cliente));

        return cadastrado ? ok().build() : status(Response.Status.BAD_REQUEST).build();

    }

    @POST
    @Path("{clienteId}/alterar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response alterarCliente(@PathParam("clienteId") Integer clienteId, AlterarClienteParameter clienteParameter) {

        boolean alterado = this.clienteService.alterarCliente(clienteId, clienteParameter);

        return ok(alterado).build();
    }

    @GET
    @Path("{clienteId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarClientePorId(@PathParam("clienteId") Integer clienteId) {

        Cliente cliente = this.clienteService.buscarClientePorId(clienteId);

        return cliente != null ? ok(new DadosClientePresenter(cliente)).build() : status(NO_CONTENT).build();
    }
}
