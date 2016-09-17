package br.com.gym.mylocalgym.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Luciano
 */
public class FaturamentoModel {

    private String nome;

    private BigDecimal valor;

    private LocalDate horario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getHorario() {
        return horario.format(DateTimeFormatter.ISO_DATE);
    }

    public void setHorario(LocalDate horario) {
        this.horario = horario;
    }

}
