package br.com.gym.mylocalgym.resource;

import br.com.gym.mylocalgym.model.FaturamentoModel;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;
import br.com.gym.mylocalgym.service.FaturamentoService;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;

/**
 * @author Luciano
 */
@Path("/transacao")
public class FaturamentoResource {

    @Inject
    private FaturamentoService service;

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTransacoes() {

        List<FaturamentoModel> list = this.service.listarTransacoes();
        return (Response) (!list.isEmpty() ? ok(list).build() : status(NO_CONTENT).build());

    }

    @GET
    @Path("/listar/{periodo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTransacoesPorPeriodo(@PathParam("periodo") String periodo) {

        List<FaturamentoModel> list = this.service.listarTransacoesPorPeriodo(periodo);
        return (Response) (!list.isEmpty() ? ok(list).build() : status(NO_CONTENT).build());

    }

    @GET
    @Path("/periodos/{academiaId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarFaturamento(
            @PathParam("academiaId") Integer academiaId) {

        Map<String, BigDecimal> valor = new HashMap<String, BigDecimal>();

        valor = this.service.listarFaturamento(academiaId);

        return (Response) (valor != null ? ok(valor).build() : status(NO_CONTENT).build());
    }

}
