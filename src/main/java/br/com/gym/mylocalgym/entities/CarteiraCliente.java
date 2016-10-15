/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gym.mylocalgym.entities;

import br.com.gym.mylocalgym.utils.DateUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
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

/**
 *
 * @author Luciano
 */
@Entity
@Table(name = "carteira_cliente")
@NamedQueries({
    @NamedQuery(name = "CarteiraCliente.findAll", query = "SELECT c FROM CarteiraCliente c"),
    @NamedQuery(name = "CarteiraCliente.findById", query = "SELECT c FROM CarteiraCliente c WHERE c.id = :id"),
    @NamedQuery(name = "CarteiraCliente.findBySaldo", query = "SELECT c FROM CarteiraCliente c WHERE c.saldo = :saldo"),
    @NamedQuery(name = "CarteiraCliente.findByDtInclusao", query = "SELECT c FROM CarteiraCliente c WHERE c.dtInclusao = :dtInclusao")})
public class CarteiraCliente implements Serializable {

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
    @Column(name = "dt_inclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInclusao;
    @JoinColumn(name = "clienteId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente clienteId;

    public CarteiraCliente() {
    }

    public CarteiraCliente(Integer id) {
        this.id = id;
    }

    public CarteiraCliente(Integer id, BigDecimal saldo, Date dtInclusao) {
        this.id = id;
        this.saldo = saldo;
        this.dtInclusao = dtInclusao;
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

    public Date getDtInclusao() {
        return dtInclusao;
    }

    public void setDtInclusao(Date dtInclusao) {
        this.dtInclusao = dtInclusao;
    }
    
    public LocalDate validadeDate(){
        return DateUtil.convertDateToLocalDate(this.dtInclusao);
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
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
        if (!(object instanceof CarteiraCliente)) {
            return false;
        }
        CarteiraCliente other = (CarteiraCliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gym.mylocalgym.entities.CarteiraCliente[ id=" + id + " ]";
    }
    
}
