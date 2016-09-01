package br.com.gym.mylocalgym.resource;

import br.com.gym.mylocalgym.entities.Academia;
import br.com.gym.mylocalgym.service.AcademiaService;
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
@Path("/academia")
public class AcademiaResource {

    @Inject
    private AcademiaService academiaService;

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarAcademia(Academia academia) {

        boolean salvo = this.academiaService.cadastrar(academia);

        return salvo ? ok().build() : status(Response.Status.BAD_REQUEST).build();

    }

}
