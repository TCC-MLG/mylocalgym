package br.com.gym.mylocalgym.presenters;

import br.com.gym.mylocalgym.entities.Cliente;

/**
 * @author Luciano
 */
public class DadosClientePresenter {

    private String nome;
    private String apelido;
    private String telefone;
    private String estado;
    private String cidade;
    private String endereco;
    private String senha;

    public DadosClientePresenter(Cliente cliente) {
        if (cliente != null) {

            this.nome = cliente.getNome();
            this.apelido = cliente.getApelido();
            this.telefone = cliente.getTelefone();
            this.estado = cliente.getEstado();
            this.cidade = cliente.getCidade();
            this.endereco = cliente.getEndereco();
            this.senha = cliente.getSenha();
        }
    }

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getSenha() {
        return senha;
    }

}
