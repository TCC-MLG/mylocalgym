package br.com.gym.mylocalgym.presenters;

import br.com.gym.mylocalgym.entities.Academia;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Luciano
 */
public class AlterarDadosAcademiaPresenter implements Serializable {
    
    private String razaoSocial;
    private String email; 
    private String telefone;
    private String cep;
    private String endereco;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private BigDecimal valorServico;
    private Integer numero;
    
    public AlterarDadosAcademiaPresenter(Academia academia){
        
        this.razaoSocial = academia.getRazaoSocial();
        this.email = academia.getEmail();
        this.telefone = academia.getTelefone();
        this.cep = academia.getCep();
        this.endereco = academia.getEndereco();
        this.complemento = academia.getComplemento();
        this.bairro = academia.getBairro();
        this.cidade = academia.getCidade();
        this.estado = academia.getEstado();
        this.valorServico = academia.getValorServico();
        this.numero = academia.getNumero();
        
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public BigDecimal getValorServico() {
        return valorServico;
    }

    public void setValorServico(BigDecimal valorServico) {
        this.valorServico = valorServico;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
                    
    
}
