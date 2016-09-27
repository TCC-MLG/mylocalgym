package br.com.gym.mylocalgym.presenters;

import br.com.gym.mylocalgym.entities.Checkin;

/**
 * @author Luciano
 */
public class CheckinClientePresenter {

    private Integer id;
    private boolean solicitacaoCliente;
    private Integer clienteId;
    private String nome;
    private String email;
    private Integer cpf;

    public CheckinClientePresenter(Checkin checkin) {

        this.id = checkin.getId();
        this.solicitacaoCliente = checkin.getSolicitacaoCliente();
        this.clienteId = checkin.getIdCliente().getId();
        this.nome = checkin.getIdCliente().getNome();
        this.email = checkin.getIdCliente().getEmail();
        this.cpf = checkin.getIdCliente().getCpf();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isSolicitacaoCliente() {
        return solicitacaoCliente;
    }

    public void setSolicitacaoCliente(boolean solicitacaoCliente) {
        this.solicitacaoCliente = solicitacaoCliente;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

}
