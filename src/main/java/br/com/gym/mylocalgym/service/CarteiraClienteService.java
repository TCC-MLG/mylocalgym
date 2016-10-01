package br.com.gym.mylocalgym.service;

import br.com.gym.mylocalgym.entities.CarteiraCliente;
import java.math.BigDecimal;

/**
 * @author Luciano
 */
public interface CarteiraClienteService {

    boolean inserirSaldo(CarteiraCliente carteiraCliente);
    
    CarteiraCliente buscarSaldoPorId(Integer idCliente);
    
}
