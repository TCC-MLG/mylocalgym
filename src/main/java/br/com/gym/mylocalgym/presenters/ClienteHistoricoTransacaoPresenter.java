package br.com.gym.mylocalgym.presenters;

import br.com.gym.mylocalgym.model.ClienteHistoricoTransacaoModel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Matheus
 */
public class ClienteHistoricoTransacaoPresenter {

    private Integer idTransacao;
    private Integer idAcademia;
    private LocalDate dataTransacao;
    private BigDecimal valor;
    private String razaoSocial;

    public ClienteHistoricoTransacaoPresenter(ClienteHistoricoTransacaoModel model) {

        if (model != null) {

            this.idTransacao = model.getIdTransacao();
            this.idAcademia = model.getIdAcademia();
            this.dataTransacao = model.getDataTransacao();
            this.valor = model.getValor();
            this.razaoSocial = model.getRazaoSocial();

        }

    }

    public Integer getIdTransacao() {
        return idTransacao;
    }

    public Integer getIdAcademia() {
        return idAcademia;
    }

    public String getDataTransacao() {
        return dataTransacao.format(DateTimeFormatter.ISO_DATE);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

}
