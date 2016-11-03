package br.com.gym.mylocalgym.entities;

import br.com.gym.mylocalgym.parameter.AcademiaParameter;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Matheus
 */
@Entity
@Table(name = "academia")
@NamedQueries({
    @NamedQuery(name = "Academia.findAll", query = "SELECT a FROM Academia a"),
    @NamedQuery(name = "Academia.findById", query = "SELECT a FROM Academia a WHERE a.id = :id"),
    @NamedQuery(name = "Academia.findByEmail", query = "SELECT a FROM Academia a WHERE a.email = :email"),
    @NamedQuery(name = "Academia.findBySenha", query = "SELECT a FROM Academia a WHERE a.senha = :senha"),
    @NamedQuery(name = "Academia.findByTelefone", query = "SELECT a FROM Academia a WHERE a.telefone = :telefone"),
    @NamedQuery(name = "Academia.findByCnpj", query = "SELECT a FROM Academia a WHERE a.cnpj = :cnpj"),
    @NamedQuery(name = "Academia.findByEstado", query = "SELECT a FROM Academia a WHERE a.estado = :estado"),
    @NamedQuery(name = "Academia.findByCidade", query = "SELECT a FROM Academia a WHERE a.cidade = :cidade"),
    @NamedQuery(name = "Academia.findByEndereco", query = "SELECT a FROM Academia a WHERE a.endereco = :endereco")})
public class Academia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "cnpj")
    private Integer cnpj;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "cep")
    private String cep;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "complemento")
    private String complemento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAcademia")
    private List<Servico> servicoList;

    public Academia() {
    }

    public Academia(Integer id) {
        this.id = id;
    }

    public Academia(Integer id, String email, String senha, String telefone, int cnpj, String estado, String cidade, String endereco) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.estado = estado;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public Academia(AcademiaParameter academia) {

        this.email = academia.getEmail();
        this.senha = academia.getSenha();
        this.telefone = academia.getTelefone();
        this.cnpj = academia.getCnpj();
        this.estado = academia.getEstado();
        this.cidade = academia.getCidade();
        this.endereco = academia.getLogradouro();
        this.razaoSocial = academia.getRazaoSocial();
        this.cep = academia.getCep();
        this.bairro = academia.getBairro();
        this.logradouro = academia.getLogradouro();
        this.numero = academia.getNumero();
        this.complemento = academia.getComplemento();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
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

    public List<Servico> getServicoList() {
        return servicoList;
    }

    public void setServicoList(List<Servico> servicoList) {
        this.servicoList = servicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Academia)) {
            return false;
        }
        Academia other = (Academia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gym.mylocalgym.models.Academia[ id=" + id + " ]";
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

}
