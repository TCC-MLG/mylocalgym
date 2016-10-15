package br.com.gym.mylocalgym.presenters;

import br.com.gym.mylocalgym.entities.CarteiraCliente;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Matheus
 */
public class SaldoClientePresenter {
    
    private final BigDecimal saldo;
    private final LocalDate validade;
    
    public SaldoClientePresenter(CarteiraCliente cliente) {
        
        this.saldo = cliente.getSaldo();
        this.validade = cliente.validadeDate().plusMonths(6);
        
    }
    
    public BigDecimal getSaldo() {
        return saldo;
    }
    
    public String getValidade() {
        return validade.format(DateTimeFormatter.ISO_DATE);
    }
    
}
