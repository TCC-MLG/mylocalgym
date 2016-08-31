package br.com.gym.mylocalgym.repository;

import entities.Academia;
import entities.Cliente;

/**
 * @author Matheus
 */
public interface LoginRepository {
   
    Cliente autenticar(String nome, String senha);

    public Academia autenticarAcademia(String cnpj, String senha);
    
}
