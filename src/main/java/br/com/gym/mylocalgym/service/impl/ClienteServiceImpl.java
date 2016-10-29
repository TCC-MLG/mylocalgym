package br.com.gym.mylocalgym.service.impl;

import br.com.gym.mylocalgym.entities.Cliente;
import br.com.gym.mylocalgym.repository.ClienteRepository;
import br.com.gym.mylocalgym.service.ClienteService;
import javax.inject.Inject;

/**
 * @author Matheus
 */
public class ClienteServiceImpl implements ClienteService {

    @Inject
    private ClienteRepository clienteRepository;

    @Override
    public Boolean cadastrarCliente(Cliente cliente) {

        return this.clienteRepository.cadastrarCliente(cliente);

    }

}
