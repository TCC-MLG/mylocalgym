package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.entities.Cliente;
import br.com.gym.mylocalgym.repository.ClienteRepository;
import org.hibernate.Session;

/**
 * @author Matheus
 */
public class ClienteRepositoryImpl implements ClienteRepository {

    Session session = HibernateUtil.session();

    @Override
    public Boolean cadastrarCliente(Cliente cliente) {

        try {

            Integer id = (Integer) this.session.save(cliente);

            return id != null;

        } catch (Exception e) {

            return false;

        }

    }

}
