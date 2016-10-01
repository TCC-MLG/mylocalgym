package br.com.gym.mylocalgym.service.impl;

import br.com.gym.mylocalgym.entities.CarteiraCliente;
import br.com.gym.mylocalgym.repository.CarteiraClienteRepository;
import br.com.gym.mylocalgym.service.CarteiraClienteService;
import java.math.BigDecimal;
import javax.inject.Inject;

/**
 * @author Luciano
 */
public class CarteiraClienteServiceImpl implements CarteiraClienteService {
    
    @Inject
    private CarteiraClienteRepository repository;

    @Override
    public boolean inserirSaldo(CarteiraCliente carteiraCliente) {
        return this.repository.inserirSaldo(carteiraCliente);
    }
    
    @Override
    public CarteiraCliente buscarSaldoPorId(Integer idCliente) {
        return this.repository.buscarSaldoPorId(idCliente);
    }
    
}
