package br.com.gym.mylocalgym.service;

import br.com.gym.mylocalgym.entities.Cliente;
import br.com.gym.mylocalgym.parameter.AlterarClienteParameter;

/**
 * @author Matheus
 */
public interface ClienteService {

    Boolean cadastrarCliente(Cliente cliente);

    boolean alterarCliente(Integer clienteId, AlterarClienteParameter cliente);

    Cliente buscarClientePorId(Integer clienteId);

}
