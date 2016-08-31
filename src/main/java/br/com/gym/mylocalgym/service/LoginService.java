package br.com.gym.mylocalgym.service;

import entities.Academia;
import entities.Cliente;

/**
 * @author Matheus
 */
public interface LoginService {
   
    Cliente autenticar(String nome, String senha);

    Academia autenticarAcademia(String cnpj, String senha);
    
}
