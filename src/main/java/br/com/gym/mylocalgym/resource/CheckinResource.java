package br.com.gym.mylocalgym.resource;

import br.com.gym.mylocalgym.entities.Checkin;
import br.com.gym.mylocalgym.presenters.CheckinClientePresenter;
import br.com.gym.mylocalgym.presenters.CheckinSolicitacaoPresenter;
import br.com.gym.mylocalgym.service.CheckinService;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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

        List<Checkin> checkins = this.checkinService.getDadosCliente(academiaId, checkinId);

        List<CheckinClientePresenter> presenters = new ArrayList<>();

        if (checkins != null && !checkins.isEmpty()) {
            for (Checkin checkin : checkins) {
                presenters.add(new CheckinClientePresenter(checkin));
            }
        }

        return (Response) (checkins != null ? ok(presenters).build() : status(NO_CONTENT).build());

    }

    @PUT
    @Path("/liberar/{checkinId}/{aprovado}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response liberarCliente(
            @PathParam("checkinId") Integer checkinId,
            @PathParam("aprovado") boolean aprovado) {

        boolean update = this.checkinService.liberarCliente(checkinId, aprovado);
        
        return update ? ok(update).build() : status(NO_CONTENT).build();
    }

}