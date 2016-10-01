package br.com.gym.mylocalgym.resource;

import br.com.gym.mylocalgym.entities.Servico;
import br.com.gym.mylocalgym.presenters.ServicoPresenter;
import br.com.gym.mylocalgym.service.ServicoService;
import java.util.ArrayList;
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
@Path("/servico")
public class ServicoResource {

    @Inject
    private ServicoService service;

    @GET
    @Path("/listar/{academiaId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTransacoesPorPeriodo(@PathParam("academiaId") Integer academiaId) {

        List<Servico> list = this.service.obterServicos(academiaId);

        List<ServicoPresenter> presenters = new ArrayList<>();
        if (list != null) {
            for (Servico servico : list) {
                presenters.add(new ServicoPresenter(servico));
            }
        }

        return (Response) (!list.isEmpty() ? ok(presenters).build() : status(NO_CONTENT).build());

    }

    @GET
    @Path("/{servicoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obterServico(@PathParam("servicoId") Integer servicoId) {

         Servico servico = this.service.obterServico(servicoId);
        
        return servico != null ? ok(new ServicoPresenter(servico)).build() : Response.noContent().build();
    }

}
