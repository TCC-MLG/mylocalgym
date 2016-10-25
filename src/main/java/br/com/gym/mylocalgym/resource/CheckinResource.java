package br.com.gym.mylocalgym.resource;

import br.com.gym.mylocalgym.entities.Checkin;
import br.com.gym.mylocalgym.parameter.CheckinParameter;
import br.com.gym.mylocalgym.parameter.SolicitarCheckinParameter;
import br.com.gym.mylocalgym.presenters.CheckinClientePresenter;
import br.com.gym.mylocalgym.presenters.CheckinSolicitacaoPresenter;
import br.com.gym.mylocalgym.service.CheckinService;
import java.util.ArrayList;
import java.util.List;
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
 * @author Luciano
 */
@Path("/checkin")
public class CheckinResource {

    @Inject
    private CheckinService checkinService;

    @GET
    @Path("/solicitacoes/{academiaId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarSolicitacao(@PathParam("academiaId") Integer academiaId) {

        List<Checkin> checkins = this.checkinService.listarSolicitacao(academiaId);

        List<CheckinSolicitacaoPresenter> presenters = new ArrayList<>();

        if (checkins != null && !checkins.isEmpty()) {
            for (Checkin checkin : checkins) {
                presenters.add(new CheckinSolicitacaoPresenter(checkin));
            }
        }

        return (Response) (checkins != null ? ok(presenters).build() : status(NO_CONTENT).build());

    }

    @GET
    @Path("{checkinId}/cliente/{academiaId}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDadosCliente(
            @PathParam("checkinId") Integer checkinId,
            @PathParam("academiaId") Integer academiaId) {

        Checkin checkin = this.checkinService.getDadosCliente(academiaId, checkinId);

        return (Response) (checkin != null ? ok(new CheckinClientePresenter(checkin)).build() : status(NO_CONTENT).build());

    }

    @POST
    @Path("/liberar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response liberarCliente(CheckinParameter parameter) {

        boolean update = this.checkinService.liberarCliente(parameter);

        return ok(update).build();
    }

    @POST
    @Path("/solicitar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response solicitarCheckin(SolicitarCheckinParameter parameter) {

        Integer id = this.checkinService.solicitarCheckin(parameter.getClienteId(), parameter.getAcademiaId());

        return id > 0 ? ok(id).build() : status(BAD_REQUEST).build();
    }

    @GET
    @Path("/solicitar/status/{clienteId}/{checkinId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verificarSolicitacao(@PathParam("clienteId") Integer clienteId,
            @PathParam("academiaId") Integer academiaId) {

        boolean validado = this.checkinService.verificarSolicitacao(clienteId, academiaId);

        return ok(validado).build();

    }
}
