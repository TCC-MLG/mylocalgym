package br.com.gym.mylocalgym.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Luciano
 */
public class FaturamentoModel {

    private LocalDate dataTransacao;

    private BigDecimal valor;

    public String getDataTransacao() {
        return dataTransacao.format(DateTimeFormatter.ISO_DATE);
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
