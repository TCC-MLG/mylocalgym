package br.com.gym.mylocalgym.resource;

import br.com.gym.mylocalgym.model.HistoricoTransacaoModel;
import br.com.gym.mylocalgym.service.HistoricoTransacaoService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;

/**
 * @author Luciano
 */
@Path("/transacao")
public class HistoricoTransacaoResource {

    @Inject
    private HistoricoTransacaoService service;

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTransacoes() {

        List<HistoricoTransacaoModel> list = this.service.listarTransacoes();
        return (Response) (!list.isEmpty() ? ok(list).build() : status(NO_CONTENT).build());

    }

    @GET
    @Path("/listar/{periodo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTransacoesPorPeriodo(@PathParam("periodo") String periodo) {

        List<HistoricoTransacaoModel> list = this.service.listarTransacoesPorPeriodo(periodo);
        return (Response) (!list.isEmpty() ? ok(list).build() : status(NO_CONTENT).build());

    }

}
