package br.com.gym.mylocalgym.repository;

import br.com.gym.mylocalgym.entities.CarteiraAcademia;
import java.math.BigDecimal;

/**
 * @author Luciano
 */
public interface CarteiraAcademiaRepository {

    public boolean inserirSaldo(Integer academiaId, BigDecimal saldo);

    public CarteiraAcademia buscarSaldoPorId(Integer academiaId);

}
