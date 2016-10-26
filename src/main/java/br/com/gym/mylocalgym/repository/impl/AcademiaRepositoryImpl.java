package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.entities.Academia;
import br.com.gym.mylocalgym.repository.AcademiaRepository;
import org.hibernate.Session;

/**
 *
 * @author Matheus
 */
public class AcademiaRepositoryImpl implements AcademiaRepository {

    Session session = HibernateUtil.session();

    @Override
    public boolean cadastrar(Academia academia) {

        try {

            this.session.persist(academia);
            this.session.getTransaction().commit();

            return academia != null;

        } catch (Exception e) {

            return false;

        }
    }

    @Override
    public Academia buscarAcademiaPorNome(String nomeAcademia) {

        Academia academia = null;

        try {
            academia = (Academia) this.session.createQuery("FROM Academia a WHERE a.razaoSocial = :academia")
                    .setParameter("academia", nomeAcademia)
                    .uniqueResult();

            return academia;
        } catch (Exception e) {
        }
        return academia;
    }

}
