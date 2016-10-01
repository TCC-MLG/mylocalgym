package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.entities.CarteiraAcademia;
import br.com.gym.mylocalgym.entities.CarteiraCliente;
import br.com.gym.mylocalgym.repository.CarteiraAcademiaRepository;
import java.math.BigDecimal;
import org.hibernate.Session;

/**
 * @author Luciano
 */
public class CarteiraAcademiaRepositoryImpl implements CarteiraAcademiaRepository {

    Session session;

    public boolean inserirSaldo(Integer academiaId, BigDecimal saldo) {

        this.session = HibernateUtil.session();

        String sql = " insert into mylocalgym.carteira_academia "
                + "(saldo, academiaId, dt_alteracao) "
                + "values (:saldo, :academiaId, sysdate()) ";

        int inserido = this.session.createSQLQuery(sql)
                .setParameter("saldo", saldo)
                .setParameter("academiaId", academiaId)
                .executeUpdate();

        this.session.getTransaction().commit();
        this.session.close();

        return inserido > 0;

    }

    @Override
    public CarteiraAcademia buscarSaldoPorId(Integer academiaId) {
        this.session = HibernateUtil.session();

        StringBuilder sql = new StringBuilder();

        sql.append(" SELECT * ")
                .append(" FROM mylocalgym.carteira_academia c ")
                .append(" where c.id = (")
                .append("      select max(cc.id) ")
                .append("      from mylocalgym.carteira_academia cc ")
                .append("      where cc.academiaId = :id) ");

        CarteiraAcademia cc = (CarteiraAcademia) this.session.createSQLQuery(sql.toString())
                .addEntity(CarteiraAcademia.class)
                .setParameter("id", academiaId)
                .uniqueResult();

        this.session.close();

        return cc;
    }

}
