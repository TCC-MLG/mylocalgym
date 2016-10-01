package br.com.gym.mylocalgym.repository;

import br.com.gym.mylocalgym.entities.CarteiraCliente;

/**
 * @author Luciano
 */
public interface CarteiraClienteRepository {

    public boolean inserirSaldo(CarteiraCliente carteiraCliente);

    public CarteiraCliente buscarSaldoPorId(Integer idCliente);
    
}
