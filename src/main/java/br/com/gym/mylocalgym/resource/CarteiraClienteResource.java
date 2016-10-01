package br.com.gym.mylocalgym.resource;

import br.com.gym.mylocalgym.service.CarteiraClienteService;
import java.math.BigDecimal;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;

/**
 * @author Luciano
 */
@Path("/carteira/cliente")
public class CarteiraClienteResource {

    @Inject
    private CarteiraClienteService service;

    @POST
    @Path("{idCliente}/inserir/{valor}")
    public Response inserirSaldo(@PathParam("idCliente") Integer idCliente,
            @PathParam("valor") BigDecimal valor) {
        boolean gravado = false;

        //gravado = this.service.inserirSaldo(idCliente, valor);

        return gravado ? ok().build() : status(BAD_REQUEST).build();

    }

}
