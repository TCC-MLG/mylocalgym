package br.com.gym.mylocalgym.repository;

import entities.Cliente;

/**
 * @author Matheus
 */
public interface LoginRepository {
   
    Cliente autenticar(String nome, String senha);
    
}
