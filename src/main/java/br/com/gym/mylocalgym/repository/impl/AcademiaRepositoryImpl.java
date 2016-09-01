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

            Integer id = (Integer) this.session.save(academia);

            return id != null;

        } catch (Exception e) {

            return false;

        }
    }

}
