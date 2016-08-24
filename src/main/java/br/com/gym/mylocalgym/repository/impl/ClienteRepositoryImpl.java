package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.repository.ClienteRepository;
import entities.Cliente;
import org.hibernate.Session;

/**
 * @author Matheus
 */
public class ClienteRepositoryImpl implements ClienteRepository {

    Session session = HibernateUtil.session();

    @Override
    public Boolean cadastrarCliente(Cliente cliente) {

        Integer id = (Integer) this.session.save(cliente);
        
        return id != null ? true : false;

    }

}
