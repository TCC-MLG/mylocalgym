package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.repository.AcademiaRepository;
import entities.Academia;
import org.hibernate.Session;

/**
 *
 * @author Matheus
 */
public class AcademiaRepositoryImpl implements AcademiaRepository {

    Session session = HibernateUtil.session();

    @Override
    public boolean cadastrar(Academia academia) {

        Integer id = (Integer) this.session.save(academia);
        
        return id != null ? true : false;
    }

}
