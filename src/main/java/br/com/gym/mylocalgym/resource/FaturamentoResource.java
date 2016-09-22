package br.com.gym.mylocalgym.resource;

import br.com.gym.mylocalgym.entities.HistoricoTransacao;
import br.com.gym.mylocalgym.model.FaturamentoModel;
import br.com.gym.mylocalgym.presenters.HistoricoClientePresenter;
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
import br.com.gym.mylocalgym.utils.DateUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.QueryParam;
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
    @Path("/listar/{academiaId}/periodo/{periodo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTransacoesPorPeriodo(@PathParam("academiaId") Integer academiaId,
            @PathParam("periodo") String periodo) {

        List<FaturamentoModel> list = this.service.listarTransacoesPorPeriodo(academiaId, periodo);
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

    @GET
    @Path("/historico/{academiaId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarHistoricoClientes(
            @PathParam("academiaId") Integer academiaId,
            @QueryParam("start") String start,
            @QueryParam("end") String end) {

        LocalDate startDate = start != null ? DateUtil.convertStringToLocalDate(start) : null;
        LocalDate endDate = end != null ? DateUtil.convertStringToLocalDate(end) : null;

        List<HistoricoTransacao> list = this.service.listarHistoricoClientes(academiaId, startDate, endDate);

        List<HistoricoClientePresenter> historicoPresenter = new ArrayList<>();

        if (list != null) {

            for (HistoricoTransacao historicoTransacao : list) {

                historicoPresenter.add(new HistoricoClientePresenter(historicoTransacao));

            }

        }

        return (Response) (list != null ? ok(historicoPresenter).build() : status(NO_CONTENT).build());
    }

}
