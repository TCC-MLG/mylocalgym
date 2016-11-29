package br.com.gym.mylocalgym.service.impl;

import br.com.gym.mylocalgym.entities.CarteiraCliente;
import br.com.gym.mylocalgym.entities.Cliente;
import br.com.gym.mylocalgym.parameter.AlterarClienteParameter;
import br.com.gym.mylocalgym.repository.ClienteRepository;
import br.com.gym.mylocalgym.service.CarteiraClienteService;
import br.com.gym.mylocalgym.service.ClienteService;
import java.math.BigDecimal;
import javax.inject.Inject;

/**
 * @author Matheus
 */
public class ClienteServiceImpl implements ClienteService {

    @Inject
    private ClienteRepository clienteRepository;

    @Inject
    private CarteiraClienteService clienteService;

    @Override
    public Boolean cadastrarCliente(Cliente cliente) {

        boolean inserido = false;
        if (cliente != null) {

            inserido = this.clienteRepository.cadastrarCliente(cliente);

            if (inserido) {
                CarteiraCliente carteiraCliente = new CarteiraCliente(cliente.getId(), BigDecimal.ZERO);
                inserido = this.clienteService.inserirSaldo(carteiraCliente);

            }

        }

        return inserido;
    }

    @Override
    public boolean alterarCliente(Integer clienteId, AlterarClienteParameter clienteParameter) {

        return this.clienteRepository.alterarCliente(clienteId, new Cliente(clienteParameter));
    }

    public Cliente buscarClientePorId(Integer clienteId) {

        return this.clienteRepository.buscarClientePorId(clienteId);
    }

    @Override
    public boolean alterarExame(Integer clienteId, Cliente cliente) {

        boolean atualizado = false;

        if (clienteId != null && cliente != null) {

            atualizado = this.clienteRepository.atualizarExame(clienteId, cliente);
        }

        return atualizado;
    }

    @Override
    public byte[] buscarExame(Integer clienteId) {
        return this.clienteRepository.buscarExame(clienteId);
    }
}
