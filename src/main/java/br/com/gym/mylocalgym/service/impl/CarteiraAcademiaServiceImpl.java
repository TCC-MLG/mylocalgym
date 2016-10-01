package br.com.gym.mylocalgym.service.impl;

import br.com.gym.mylocalgym.entities.CarteiraAcademia;
import br.com.gym.mylocalgym.repository.CarteiraAcademiaRepository;
import br.com.gym.mylocalgym.service.CarteiraAcademiaService;
import java.math.BigDecimal;
import javax.inject.Inject;

/**
 * @author Luciano
 */
public class CarteiraAcademiaServiceImpl implements CarteiraAcademiaService {

    @Inject
    private CarteiraAcademiaRepository repository;

    @Override
    public boolean inserirSaldo(Integer academiaId, BigDecimal saldo) {

        return this.repository.inserirSaldo(academiaId, saldo);

    }

    public CarteiraAcademia buscarSaldoPorId(Integer academiaId) {

        return this.repository.buscarSaldoPorId(academiaId);
    }

}
