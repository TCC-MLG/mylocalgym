package br.com.gym.mylocalgym.presenters;

import br.com.gym.mylocalgym.entities.Servico;
import java.math.BigDecimal;

/**
 *
 * @author Luciano
 */
public class ServicoPresenter {

    private Integer id;
    private String nome;
    private boolean padrao;
    private BigDecimal preco;
    private String tipo;

    public ServicoPresenter(Servico servico) {

        this.id = servico.getId();
        this.nome = servico.getNome();
        this.padrao = servico.isPadrao();
        this.preco = servico.getPreco();
        this.tipo = servico.getTipo();

    }

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

    public boolean isPadrao() {
        return padrao;
    }

    public void setPadrao(boolean padrao) {
        this.padrao = padrao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
