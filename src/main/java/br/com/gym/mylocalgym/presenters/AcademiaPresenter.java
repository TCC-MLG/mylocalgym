package br.com.gym.mylocalgym.presenters;

import br.com.gym.mylocalgym.entities.Academia;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Luciano
 */
public class AcademiaPresenter {

    private Integer id;
    private String razaoSocial;
    private String endereco;
    private BigDecimal valorServico; 
    private LocalDate funcionamento;

    public AcademiaPresenter(Academia academia) {
        
        this.id = academia.getId();
        this.razaoSocial = academia.getRazaoSocial();
        this.endereco = academia.getEndereco();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getValorServico() {
        return valorServico;
    }

    public LocalDate getFuncionamento() {
        return funcionamento;
    }

}
