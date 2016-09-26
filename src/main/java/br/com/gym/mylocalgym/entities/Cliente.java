package br.com.gym.mylocalgym.entities;

import br.com.gym.mylocalgym.parameter.ClienteParameter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Matheus
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Column(name = "ultima_recarga")
    @Temporal(TemporalType.DATE)
    private Date ultimaRecarga;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "nome")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "email")
    private String email;
    @Size(max = 13)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 10)
    @Column(name = "apelido")
    private String apelido;
    @Size(max = 8)
    @Column(name = "senha")
    private String senha;
    @Column(name = "cpf")
    private Integer cpf;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "exame_medico")
    private String exameMedico;
    @Size(max = 30)
    @Column(name = "estado")
    private String estado;
    @Size(max = 20)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 30)
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "validade_saldo")
    @Temporal(TemporalType.DATE)
    private Date validadeSaldo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private BigDecimal saldo;
  
    public Cliente() {
    }
    
    public Cliente(ClienteParameter clienteParameter) {
        
   this.nome = clienteParameter.getNome();
   this.email = clienteParameter.getEmail() ;
   this.telefone = clienteParameter.getTelefone();
   this.apelido = clienteParameter.getApelido();
   this.senha = clienteParameter.getSenha();
   this.cpf = clienteParameter.getCpf();
   this.exameMedico = clienteParameter.getExameMedico();
   this.estado = clienteParameter.getEstado();
   this.cidade = clienteParameter.getCidade();
   this.endereco = clienteParameter.getApelido();
   this.validadeSaldo = clienteParameter.getValidadeSaldo();
   this.saldo = clienteParameter.getSaldo();
        
    }

    public Cliente(Integer id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gym.mylocalgym.models.Cliente[ id=" + id + " ]";
    }

    public Date getUltimaRecarga() {
        return ultimaRecarga;
    }

    public void setUltimaRecarga(Date ultimaRecarga) {
        this.ultimaRecarga = ultimaRecarga;
    }
    
}
