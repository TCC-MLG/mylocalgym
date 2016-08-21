package entities;
// Generated 21/08/2016 12:05:28 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * HistoricoCredito generated by hbm2java
 */
public class HistoricoCredito  implements java.io.Serializable {


     private Integer id;
     private Cliente cliente;
     private BigDecimal valor;
     private Date dataCredito;

    public HistoricoCredito() {
    }

	
    public HistoricoCredito(Cliente cliente) {
        this.cliente = cliente;
    }
    public HistoricoCredito(Cliente cliente, BigDecimal valor, Date dataCredito) {
       this.cliente = cliente;
       this.valor = valor;
       this.dataCredito = dataCredito;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public BigDecimal getValor() {
        return this.valor;
    }
    
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public Date getDataCredito() {
        return this.dataCredito;
    }
    
    public void setDataCredito(Date dataCredito) {
        this.dataCredito = dataCredito;
    }




}


