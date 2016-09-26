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

}
