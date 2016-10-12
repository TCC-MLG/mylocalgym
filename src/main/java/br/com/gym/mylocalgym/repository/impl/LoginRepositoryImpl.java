package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.entities.Academia;
import br.com.gym.mylocalgym.entities.Cliente;
import br.com.gym.mylocalgym.repository.LoginRepository;
import org.hibernate.Session;

/**
 * @author Matheus
 */
public class LoginRepositoryImpl implements LoginRepository {

    Session session = HibernateUtil.session();

    @Override
    public Cliente autenticar(String apelido, String senha) {

        try {

            Cliente cliente = (Cliente) this.session.createQuery("FROM Cliente c WHERE c.email = :email ")
                    .setParameter("email", apelido)
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

    @Override
    public Academia autenticarAcademia(String cnpj, String senha) {

        if (cnpj != null && senha != null) {

            try {

                Academia academia = (Academia) this.session.createQuery("FROM Academia a where a.cnpj = :cnpj")
                        .setParameter("cnpj", Integer.valueOf(cnpj))
                        .uniqueResult();

                if (academia.getSenha().equals(senha)) {
                    return academia;
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

}
