package br.com.gym.mylocalgym.presenters;

import br.com.gym.mylocalgym.entities.HistoricoTransacao;
import br.com.gym.mylocalgym.utils.DateUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Luciano
 */
public class HistoricoClientePresenter implements Serializable {

    private Integer id;
    private String nome;
    private Integer cpf;
    private String email;
    private String telefone;
    private boolean exameMedico;
    private String cidade;
    private String endereco;
    private String estado;
    private BigDecimal valor;
    private LocalDate dataTransacao;

    public HistoricoClientePresenter() {
    }

    public HistoricoClientePresenter(HistoricoTransacao historicoTransacao) {

        this.id = historicoTransacao.getIdCliente().getId();
        this.nome = historicoTransacao.getIdCliente().getNome();
        this.cpf = historicoTransacao.getIdCliente().getCpf();
        this.email = historicoTransacao.getIdCliente().getEmail();
        this.telefone = historicoTransacao.getIdCliente().getTelefone();
        this.exameMedico = historicoTransacao.getIdCliente().getExameMedico() != null;
        this.cidade = historicoTransacao.getIdCliente().getCidade();
        this.endereco = historicoTransacao.getIdCliente().getEndereco();
        this.estado = historicoTransacao.getIdCliente().getEstado();
        this.valor = historicoTransacao.getValor();
        this.dataTransacao = DateUtil.convertDateToLocalDate(historicoTransacao.getDataTransacao());

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
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

    public boolean isExameMedico() {
        return exameMedico;
    }

    public void setExameMedico(boolean exameMedico) {
        this.exameMedico = exameMedico;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDataTransacao() {
        return dataTransacao.format(DateTimeFormatter.ISO_DATE);
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
