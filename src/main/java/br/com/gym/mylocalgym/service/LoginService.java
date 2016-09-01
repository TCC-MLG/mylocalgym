package br.com.gym.mylocalgym.service;

import br.com.gym.mylocalgym.entities.Academia;
import br.com.gym.mylocalgym.entities.Cliente;

/**
 * @author Matheus
 */
public interface LoginService {

    Cliente autenticar(String nome, String senha);

    Academia autenticarAcademia(String cnpj, String senha);

}
