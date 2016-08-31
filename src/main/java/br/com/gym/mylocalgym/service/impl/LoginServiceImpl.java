package br.com.gym.mylocalgym.service.impl;

import br.com.gym.mylocalgym.repository.LoginRepository;
import br.com.gym.mylocalgym.service.LoginService;
import entities.Academia;
import entities.Cliente;
import javax.inject.Inject;

/**
 * @author Matheus
 */
public class LoginServiceImpl implements LoginService {

    @Inject
    private LoginRepository loginRepository;

    @Override
    public Cliente autenticar(String nome, String senha) {
        
        return this.loginRepository.autenticar(nome, senha);
    
    }

    @Override
    public Academia autenticarAcademia(String cnpj, String senha) {
        
        return this.loginRepository.autenticarAcademia(cnpj, senha);
        
    }

}
