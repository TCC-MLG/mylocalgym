package br.com.gym.mylocalgym.repository;

import br.com.gym.mylocalgym.entities.Academia;
import br.com.gym.mylocalgym.entities.Cliente;

/**
 * @author Matheus
 */
public interface LoginRepository {
   
    Cliente autenticar(String nome, String senha);

    public Academia autenticarAcademia(Long cnpj, String senha);
    
}
