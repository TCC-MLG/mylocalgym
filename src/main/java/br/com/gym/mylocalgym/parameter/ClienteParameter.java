package br.com.gym.mylocalgym.parameter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Matheus
 */
public class ClienteParameter {

    private String nome;
    private String email;
    private String telefone;
    private String apelido;
    private String senha;
    private Integer cpf;
    private String exameMedico;
    private String estado;
    private String cidade;
    private String endereco;
    private Date validadeSaldo;
    private BigDecimal saldo;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getExameMedico() {
        return exameMedico;
    }

    public void setExameMedico(String exameMedico) {
        this.exameMedico = exameMedico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getValidadeSaldo() {
        return validadeSaldo;
    }

    public void setValidadeSaldo(Date validadeSaldo) {
        this.validadeSaldo = validadeSaldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    
}
