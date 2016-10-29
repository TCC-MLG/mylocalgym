package br.com.gym.mylocalgym.service;

import br.com.gym.mylocalgym.entities.CarteiraAcademia;
import java.math.BigDecimal;

/**
 * @author Luciano
 */
public interface CarteiraAcademiaService {
    
    public boolean inserirSaldo(Integer academiaId, BigDecimal saldo);
    
    public CarteiraAcademia buscarSaldoPorId(Integer academiaId);
    
}
