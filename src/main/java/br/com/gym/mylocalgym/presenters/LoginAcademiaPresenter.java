package br.com.gym.mylocalgym.presenters;

import br.com.gym.mylocalgym.entities.Academia;
import java.math.BigDecimal;

/**
 *
 * @author Matheus
 */
public class LoginAcademiaPresenter {

    private Integer id;
    private BigDecimal valorServico;

    public LoginAcademiaPresenter(Academia academia) {

        if (academia != null) {

            this.id = academia.getId();
            this.valorServico = academia.getValorServico();

        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorServico() {
        return valorServico;
    }

    public void setValorServico(BigDecimal valorServico) {
        this.valorServico = valorServico;
    }
}
