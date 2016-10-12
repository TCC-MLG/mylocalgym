package br.com.gym.mylocalgym.presenters;

import br.com.gym.mylocalgym.entities.Cliente;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Matheus
 */
@XmlRootElement
public class LoginPresenter {

    private Integer id;

    @XmlElement
    private boolean validado = true;

    @XmlElement
    private String login;

    @XmlElement
    private String nome;

    @XmlElement
    private String email;

    public LoginPresenter(Cliente cliente) {

        this.id = cliente.getId();
        this.login = cliente.getApelido();
        this.email = cliente.getEmail();
        this.nome = cliente.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

}
