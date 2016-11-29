package br.com.gym.mylocalgym.resource;

import br.com.gym.mylocalgym.entities.CarteiraAcademia;
import br.com.gym.mylocalgym.presenters.SaldoAcademiaPresenter;
import br.com.gym.mylocalgym.service.CarteiraAcademiaService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;

/**
 * @author mgraciano
 */
@Path("/carteira/cliente")
public class CarteiraAcademiaResource {

    @Inject
    private CarteiraAcademiaService carteiraAcademiaService;

    @GET
    @Path("saldo/{idCliente}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarSaldoPorId(@PathParam("idCliente") Integer idCliente) {

        CarteiraAcademia cliente = this.carteiraAcademiaService.buscarSaldoPorId(idCliente);

        return cliente != null ? ok(new SaldoAcademiaPresenter(cliente)).build() : status(BAD_REQUEST).build();

    }

}
