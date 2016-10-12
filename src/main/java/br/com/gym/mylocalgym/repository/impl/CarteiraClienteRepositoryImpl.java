package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.entities.CarteiraCliente;
import br.com.gym.mylocalgym.repository.CarteiraClienteRepository;
import org.hibernate.Session;

/**
 * @author Luciano
 */
public class CarteiraClienteRepositoryImpl implements CarteiraClienteRepository {

    Session session;

    @Override
    public boolean inserirSaldo(CarteiraCliente carteiraCliente) {
        this.session = HibernateUtil.session();
        String sql = " insert into mylocalgym.carteira_cliente "
                + "(saldo, clienteId, dt_inclusao) "
                + "values (:saldo, :clienteId, sysdate()) ";

        int inseriu = this.session.createSQLQuery(sql)
                .setParameter("saldo", carteiraCliente.getSaldo())
                .setParameter("clienteId", carteiraCliente.getClienteId())
                .executeUpdate();

        this.session.getTransaction().commit();
        this.session.close();

        return inseriu > 0;
    }

    @Override
    public CarteiraCliente buscarSaldoPorId(Integer clienteId) {
        this.session = HibernateUtil.session();

        StringBuilder sql = new StringBuilder();

        sql.append(" SELECT * ")
                .append(" FROM mylocalgym.carteira_cliente c ")
                .append(" where c.id = (")
                .append("      select max(cc.id) ")
                .append("      from mylocalgym.carteira_cliente cc ")
                .append("      where cc.clienteId = :id) ");

        CarteiraCliente cc = (CarteiraCliente) this.session.createSQLQuery(sql.toString())
                .addEntity(CarteiraCliente.class)
                .setParameter("id", clienteId)
                .uniqueResult();

        this.session.close();

        return cc;
    }

}
