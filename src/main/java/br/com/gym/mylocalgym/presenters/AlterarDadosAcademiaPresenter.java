package br.com.gym.mylocalgym.presenters;

import br.com.gym.mylocalgym.entities.Academia;

/**
 * @author Luciano
 */
public class AlterarDadosAcademiaPresenter {
    
    private String razãoSocial;
    private String email; 
    private String telefone;
    private String cep;
    private String endereco;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    
    public AlterarDadosAcademiaPresenter(Academia academia){
        
        this.razãoSocial = academia.getRazaoSocial();
        this.email = academia.getEmail();
        this.telefone = academia.getTelefone();
        this.cep = academia.getCep();
        this.endereco = academia.getEndereco();
        this.complemento = academia.getComplemento();
        this.bairro = academia.getBairro();
        this.cidade = academia.getCidade();
        this.estado = academia.getEstado();
        
    }

    public String getRazãoSocial() {
        return razãoSocial;
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
                    
    
}
