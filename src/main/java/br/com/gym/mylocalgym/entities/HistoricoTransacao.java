/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gym.mylocalgym.entities;

import br.com.gym.mylocalgym.model.FaturamentoModel;
import br.com.gym.mylocalgym.utils.DateUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
 * @author Matheus
 */
@Entity
@Table(name = "historico_transacao")
@NamedQueries({
    @NamedQuery(name = "HistoricoTransacao.findAll", query = "SELECT h FROM HistoricoTransacao h"),
    @NamedQuery(name = "HistoricoTransacao.findById", query = "SELECT h FROM HistoricoTransacao h WHERE h.id = :id"),
    @NamedQuery(name = "HistoricoTransacao.findByDataTransacao", query = "SELECT h FROM HistoricoTransacao h WHERE h.dataTransacao = :dataTransacao"),
    @NamedQuery(name = "HistoricoTransacao.findByValor", query = "SELECT h FROM HistoricoTransacao h WHERE h.valor = :valor")})
public class HistoricoTransacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "data_transacao")
    @Temporal(TemporalType.DATE)
    private Date dataTransacao;

    @Column(name = "valor")
    private BigDecimal valor;

    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente idCliente;

    @JoinColumn(name = "id_academia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Academia idAcademia;

    public FaturamentoModel convert() {

        FaturamentoModel transacaoParameter = new FaturamentoModel();

        transacaoParameter.setDataTransacao(DateUtil.convertDateToLocalDate(this.dataTransacao));
        transacaoParameter.setValor(this.valor);

        return transacaoParameter;

    }

    public HistoricoTransacao() {
    }

    public HistoricoTransacao(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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
        if (!(object instanceof HistoricoTransacao)) {
            return false;
        }
        HistoricoTransacao other = (HistoricoTransacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gym.mylocalgym.models.HistoricoTransacao[ id=" + id + " ]";
    }

    public Academia getIdAcademia() {
        return idAcademia;
    }

    public void setIdAcademia(Academia idAcademia) {
        this.idAcademia = idAcademia;
    }

}
