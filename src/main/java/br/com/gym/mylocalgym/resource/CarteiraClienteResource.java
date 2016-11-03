package br.com.gym.mylocalgym.resource;

import br.com.gym.mylocalgym.entities.CarteiraCliente;
import br.com.gym.mylocalgym.entities.Cliente;
import br.com.gym.mylocalgym.presenters.SaldoClientePresenter;
import br.com.gym.mylocalgym.service.CarteiraClienteService;
import java.math.BigDecimal;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.ok;
import static javax.ws.rs.core.Response.status;

/**
 * @author Luciano
 */
@Path("/carteira/cliente")
public class CarteiraClienteResource {

    @Inject
    private CarteiraClienteService service;

    @POST
    @Path("{idCliente}/inserir/{valor}")
    public Response inserirSaldo(@PathParam("idCliente") Integer idCliente,
            @PathParam("valor") BigDecimal valor) {
        boolean gravado = false;

        CarteiraCliente carteira = this.service.buscarSaldoPorId(idCliente);
        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        
        BigDecimal novoSaldo = carteira.getSaldo().add(valor);
        
        carteira.setClienteId(cliente);
        carteira.setSaldo(novoSaldo);

        gravado = this.service.inserirSaldo(carteira);

        return gravado ? ok(gravado).build() : status(BAD_REQUEST).build();

    }

    @GET
    @Path("saldo/{idCliente}")
    public Response buscarSaldoPorId(@PathParam("idCliente") Integer idCliente) {

        CarteiraCliente cliente = this.service.buscarSaldoPorId(idCliente);
        
        return cliente != null ? ok(new SaldoClientePresenter(cliente)).build() : status(BAD_REQUEST).build();

    }

}
