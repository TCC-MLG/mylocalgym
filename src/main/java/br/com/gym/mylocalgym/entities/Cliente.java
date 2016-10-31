package br.com.gym.mylocalgym.entities;

import br.com.gym.mylocalgym.parameter.AlterarClienteParameter;
import br.com.gym.mylocalgym.parameter.ClienteParameter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

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
    private Long cpf;
    @Lob
    @Column(name = "exame_medico")
    private byte[] exameMedico;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Size(max = 30)
    @Column(name = "estado")
    private String estado;
    @Size(max = 20)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 30)
    @Column(name = "endereco")
    private String endereco;

    public Cliente() {
    }

    public Cliente(AlterarClienteParameter clienteParameter) {

        this.nome = clienteParameter.getNome();
        this.apelido = clienteParameter.getApelido();
        this.telefone = clienteParameter.getTelefone();
        this.estado = clienteParameter.getEstado();
        this.cidade = clienteParameter.getCidade();
        this.endereco = clienteParameter.getApelido();
        this.senha = clienteParameter.getSenha();
        this.foto = clienteParameter.getFoto();//this.byteArrayToString(clienteParameter.getFoto());
        this.exameMedico = clienteParameter.getExame();//this.byteArrayToString(clienteParameter.getExame());

    }

    public Cliente(ClienteParameter clienteParameter) {

        this.nome = clienteParameter.getNome();
        this.email = clienteParameter.getEmail();
        this.apelido = clienteParameter.getApelido();
        this.telefone = clienteParameter.getTelefone();
        this.cpf = clienteParameter.getCpf();
        this.estado = clienteParameter.getEstado();
        this.cidade = clienteParameter.getCidade();
        this.endereco = clienteParameter.getApelido();
        this.senha = clienteParameter.getSenha();

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

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
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

    public byte[] getExameMedico() {
        return exameMedico;
    }

    public void setExameMedico(byte[] exameMedico) {
        this.exameMedico = exameMedico;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public byte[] stringToByteArray(String array) {
        if (array != null) {
            byte[] bytes = array.getBytes();
            return bytes;
        }
        return null;
    }

    public String byteArrayToString(byte[] bs) {
        if (bs != null) {
            String s = new String(bs);
            return s;
        }
        return null;
    }

}
