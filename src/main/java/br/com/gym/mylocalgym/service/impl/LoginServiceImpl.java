package br.com.gym.mylocalgym.service.impl;

import br.com.gym.mylocalgym.repository.LoginRepository;
import br.com.gym.mylocalgym.service.LoginService;
import javax.inject.Inject;

/**
 * @author Matheus
 */
public class LoginServiceImpl implements LoginService {

    @Inject
    private LoginRepository loginRepository;

    @Override
    public boolean autenticar() {

        return loginRepository.autenticar();
    }

}
