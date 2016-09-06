/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gym.mylocalgym.entities;

import br.com.gym.mylocalgym.parameter.AcademiaParameter;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cnpj")
    private Integer cnpj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "endereco")
    private String endereco;
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
        this.endereco = academia.getEndereco();

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
        // TODO: Warning - this method won't work in the case the id fields are not set
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

}
