package br.com.gym.mylocalgym.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Luciano
 */
public class HistoricoAcademiaModel {
    
    private String nomeAcademia;
    private String endereco;
    private LocalDate data;

    public String getNomeAcademia() {
        return nomeAcademia;
    }

    public void setNomeAcademia(String nomeAcademia) {
        this.nomeAcademia = nomeAcademia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getData() {
        return data.format(DateTimeFormatter.ISO_DATE);
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
}
