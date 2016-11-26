package br.com.gym.mylocalgym.resource;

import br.com.gym.mylocalgym.entities.Academia;
import br.com.gym.mylocalgym.parameter.AcademiaParameter;
import br.com.gym.mylocalgym.parameter.AlterarAcademiaParameter;
import br.com.gym.mylocalgym.presenters.AcademiaPresenter;
import br.com.gym.mylocalgym.presenters.AlterarDadosAcademiaPresenter;
import br.com.gym.mylocalgym.service.AcademiaService;
import java.math.BigDecimal;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;
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
    public Response cadastrarAcademia(AcademiaParameter academia) {

        Academia academiaEntity = new Academia(academia);
        academiaEntity.setValorServico(new BigDecimal(12));

        boolean salvo = this.academiaService.cadastrar(academiaEntity);

        return salvo ? status(NO_CONTENT).build() : status(BAD_REQUEST).build();

    }

    @GET
    @Path("{nomeAcademia}")
    public Response buscarAcademiaPorNome(@PathParam("nomeAcademia") String nomeAcademia) {

        Academia academia = this.academiaService.buscarAcademiaPorNome(nomeAcademia);

        return academia != null ? ok(new AcademiaPresenter(academia)).build() : status(NO_CONTENT).build();
    }

    @GET
    @Path("{academiaId}/dadosCompleto")
    public Response buscarDadosAcademia(@PathParam("academiaId") Integer academiaId) {

        Academia academia = this.academiaService.buscarDadosAcademia(academiaId);

        AlterarDadosAcademiaPresenter academiaPresenter = new AlterarDadosAcademiaPresenter(academia);

        return academia != null ? ok(academiaPresenter).build() : status(BAD_REQUEST).build();
    }

    @POST
    @Path("{academiaId}/alterar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarAcademia(
            @PathParam("academiaId") Integer academiaId, AlterarAcademiaParameter academia) {

        boolean alterado = false;
        Academia academiaEntity = this.academiaService.buscarDadosAcademia(academiaId);

        if (academiaEntity != null) {

            academiaEntity.setEmail(academia.getEmail());
            academiaEntity.setTelefone(academia.getTelefone());
            academiaEntity.setEstado(academia.getEstado());
            academiaEntity.setCidade(academia.getCidade());
            academiaEntity.setCep(academia.getCep());
            academiaEntity.setBairro(academia.getBairro());
            academiaEntity.setComplemento(academia.getComplemento());

            alterado = this.academiaService.alterarAcademia(academiaEntity);

        }

        return alterado ? status(NO_CONTENT).build() : status(BAD_REQUEST).build();
    }

}
