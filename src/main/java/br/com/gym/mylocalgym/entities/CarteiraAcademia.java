/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gym.mylocalgym.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luciano
 */
@Entity
@Table(name = "carteira_academia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarteiraAcademia.findAll", query = "SELECT c FROM CarteiraAcademia c"),
    @NamedQuery(name = "CarteiraAcademia.findById", query = "SELECT c FROM CarteiraAcademia c WHERE c.id = :id"),
    @NamedQuery(name = "CarteiraAcademia.findBySaldo", query = "SELECT c FROM CarteiraAcademia c WHERE c.saldo = :saldo"),
    @NamedQuery(name = "CarteiraAcademia.findByDtAlteracao", query = "SELECT c FROM CarteiraAcademia c WHERE c.dtAlteracao = :dtAlteracao")})
public class CarteiraAcademia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "saldo")
    private BigDecimal saldo;
    @Basic(optional = false)
    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAlteracao;
    @JoinColumn(name = "academiaId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Academia academiaId;

    public CarteiraAcademia() {
    }

    public CarteiraAcademia(Integer id) {
        this.id = id;
    }

    public CarteiraAcademia(Integer id, BigDecimal saldo, Date dtAlteracao) {
        this.id = id;
        this.saldo = saldo;
        this.dtAlteracao = dtAlteracao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Date getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(Date dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    public Academia getAcademiaId() {
        return academiaId;
    }

    public void setAcademiaId(Academia academiaId) {
        this.academiaId = academiaId;
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
        if (!(object instanceof CarteiraAcademia)) {
            return false;
        }
        CarteiraAcademia other = (CarteiraAcademia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gym.mylocalgym.entities.CarteiraAcademia[ id=" + id + " ]";
    }
    
}
