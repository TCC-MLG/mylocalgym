package br.com.gym.mylocalgym.repository;

import br.com.gym.mylocalgym.entities.Cliente;

/**
 *
 * @author Matheus
 */
public interface ClienteRepository {

    Boolean cadastrarCliente(Cliente cliente);

    boolean alterarCliente(Integer clienteId, Cliente cliente);

    }
