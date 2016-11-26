package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.entities.Academia;
import br.com.gym.mylocalgym.repository.AcademiaRepository;
import java.math.BigDecimal;
import org.hibernate.Session;

/**
 *
 * @author Matheus
 */
public class AcademiaRepositoryImpl implements AcademiaRepository {

    Session session;

    @Override
    public boolean cadastrar(Academia academia) {

        try {

            this.session = HibernateUtil.session();

            this.session.persist(academia);

            this.session.getTransaction().commit();
            this.session.close();

            return academia != null;

        } catch (Exception e) {

            return false;

        }
    }

    @Override
    public Academia buscarAcademiaPorNome(String nomeAcademia) {

        Academia academia = null;

        try {
            session = HibernateUtil.session();

            academia = (Academia) this.session.createQuery("FROM Academia a WHERE a.razaoSocial = :academia")
                    .setParameter("academia", nomeAcademia)
                    .uniqueResult();

            this.session.getTransaction().commit();
            this.session.close();

            return academia;
        } catch (Exception e) {
        }
        return academia;
    }

    @Override
    public Academia buscarDadosAcademia(Integer academiaId) {

        Academia academia = null;
        try {
            session = HibernateUtil.session();

            academia = (Academia) this.session.createQuery("FROM Academia a WHERE a.id = :academiaId")
                    .setParameter("academiaId", academiaId)
                    .uniqueResult();

            this.session.getTransaction().commit();
            this.session.close();

        } catch (Exception e) {
        }
        return academia;
    }

    @Override
    public boolean alterarAcademia(Academia academiaEntity) {

        int result = 0;
        try {

            session = HibernateUtil.session();

            this.session.update(academiaEntity);

            this.session.getTransaction().commit();
            this.session.close();

            result = 1;

        } catch (Exception e) {

        }

        return result > 0;
    }

    @Override
    public boolean alterarServico(Academia academia) {

        int result = 0;
        try {
            
            session = HibernateUtil.session();

            this.session.update(academia);

            this.session.getTransaction().commit();
            this.session.close();

            result = 1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result > 0;
    }

}
