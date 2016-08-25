package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.repository.LoginRepository;
import entities.Cliente;
import org.hibernate.Session;

/**
 * @author Matheus
 */
public class LoginRepositoryImpl implements LoginRepository {

    Session session = HibernateUtil.session();

    @Override
    public Cliente autenticar(String apelido, String senha) {

        try {

            Cliente cliente = (Cliente) session.createQuery("FROM Cliente c WHERE c.apelido = :apelido ")
                    .setParameter("apelido", apelido)
                    .uniqueResult();

            if (cliente != null) {
                if (cliente.getSenha().equals(senha)) {
                    return cliente;
                }
            }

        } catch (Exception e) {

            return null;

        }
        return null;
    }

}
