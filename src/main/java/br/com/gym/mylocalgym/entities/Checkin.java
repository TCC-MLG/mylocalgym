package br.com.gym.mylocalgym.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Luciano
 */
@Entity
@Table(name = "checkin")
@NamedQueries({
    @NamedQuery(name = "Checkin.findAll", query = "SELECT c FROM Checkin c"),
    @NamedQuery(name = "Checkin.findByIdCheckin", query = "SELECT c FROM Checkin c WHERE c.id = :id"),
    @NamedQuery(name = "Checkin.findBySolicitacaoCliente", query = "SELECT c FROM Checkin c WHERE c.solicitacaoCliente = :solicitacaoCliente"),
    @NamedQuery(name = "Checkin.findByAprovacaoAcademia", query = "SELECT c FROM Checkin c WHERE c.aprovacaoAcademia = :aprovacaoAcademia"),
    @NamedQuery(name = "Checkin.findByInAtivoInativo", query = "SELECT c FROM Checkin c WHERE c.inAtivoInativo = :inAtivoInativo")})
public class Checkin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "solicitacao_cliente")
    private boolean solicitacaoCliente;

    @NotNull
    @Column(name = "aprovacao_academia")
    private boolean aprovacaoAcademia;

    @NotNull
    @Column(name = "in_ativo_inativo")
    private boolean inAtivoInativo;

    @JoinColumn(name = "id_academia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Academia idAcademia;

    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente idCliente;

    public Checkin() {
    }

    public Checkin(Integer idCheckin) {
        this.id = idCheckin;
    }

    public Checkin(Integer idCheckin, boolean solicitacaoCliente, boolean aprovacaoAcademia, boolean inAtivoInativo) {
        this.id = idCheckin;
        this.solicitacaoCliente = solicitacaoCliente;
        this.aprovacaoAcademia = aprovacaoAcademia;
        this.inAtivoInativo = inAtivoInativo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idCheckin) {
        this.id = idCheckin;
    }

    public boolean getSolicitacaoCliente() {
        return solicitacaoCliente;
    }

    public void setSolicitacaoCliente(boolean solicitacaoCliente) {
        this.solicitacaoCliente = solicitacaoCliente;
    }

    public boolean getAprovacaoAcademia() {
        return aprovacaoAcademia;
    }

    public void setAprovacaoAcademia(boolean aprovacaoAcademia) {
        this.aprovacaoAcademia = aprovacaoAcademia;
    }

    public boolean getInAtivoInativo() {
        return inAtivoInativo;
    }

    public void setInAtivoInativo(boolean inAtivoInativo) {
        this.inAtivoInativo = inAtivoInativo;
    }

    public Academia getIdAcademia() {
        return idAcademia;
    }

    public void setIdAcademia(Academia idAcademia) {
        this.idAcademia = idAcademia;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
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
        if (!(object instanceof Checkin)) {
            return false;
        }
        Checkin other = (Checkin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gym.mylocalgym.entities.Checkin[ idCheckin=" + id + " ]";
    }

}
