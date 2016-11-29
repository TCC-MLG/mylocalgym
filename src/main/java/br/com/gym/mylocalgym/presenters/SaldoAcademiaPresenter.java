package br.com.gym.mylocalgym.presenters;

import br.com.gym.mylocalgym.entities.CarteiraAcademia;
import java.math.BigDecimal;

/**
 * @author mgraciano
 */
public class SaldoAcademiaPresenter {

    private BigDecimal saldo;

    public SaldoAcademiaPresenter(CarteiraAcademia cliente) {
        this.saldo = cliente.getSaldo();
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

}
