package br.com.gym.mylocalgym.repository;

import br.com.gym.mylocalgym.entities.Cliente;

/**
 *
 * @author Matheus
 */
public interface ClienteRepository {

    Boolean cadastrarCliente(Cliente cliente);

    boolean alterarCliente(Integer clienteId, Cliente cliente);

    Cliente buscarClientePorId(Integer clienteId);

    public boolean atualizarExame(Integer clienteId, Cliente cliente);

    public byte[] buscarExame(Integer clienteId);

}
