package br.com.gym.mylocalgym.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Luciano
 */
public class HistoricoTransacaoModel {

    private Date dataTransacao;
    private BigDecimal valor;

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
