package br.com.gym.mylocalgym.presenters;

import br.com.gym.mylocalgym.entities.Checkin;

/**
 * @author Luciano
 */
public class CheckinSolicitacaoPresenter {
    
    private Integer id;
    private String nome;
    
    public CheckinSolicitacaoPresenter(Checkin checkin){
        
        this.id = checkin.getId();
        this.nome = checkin.getIdCliente().getNome();
        
    }

    public CheckinSolicitacaoPresenter() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
