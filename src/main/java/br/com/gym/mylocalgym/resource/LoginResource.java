package br.com.gym.mylocalgym.resource;

import br.com.gym.mylocalgym.entities.Academia;
import br.com.gym.mylocalgym.entities.Cliente;
import br.com.gym.mylocalgym.presenters.LoginAcademiaPresenter;
import br.com.gym.mylocalgym.presenters.LoginPresenter;
import br.com.gym.mylocalgym.service.LoginService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.ok;

/**
 * @author Matheus
 */
@Path("/login")
public class LoginResource {

    @Inject
    private LoginService loginService;

    @GET
    @Path("/autenticar/{login}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response autenticar(@PathParam("login") String login, @PathParam("senha") String senha) {

        Cliente cliente = this.loginService.autenticar(login, senha);

        LoginPresenter presenter = new LoginPresenter(cliente);

        return cliente != null ? ok(presenter).build() : Response.noContent().build();
    }

    @GET
    @Path("/academia/{cnpj}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response autenticarAcademia(@PathParam("cnpj") String cnpj, @PathParam("senha") String senha) {

        Academia academia = this.loginService.autenticarAcademia(cnpj, senha);

        LoginAcademiaPresenter presenter = new LoginAcademiaPresenter(academia);

        return academia != null ? ok(presenter).build() : Response.noContent().build();
    }

}
