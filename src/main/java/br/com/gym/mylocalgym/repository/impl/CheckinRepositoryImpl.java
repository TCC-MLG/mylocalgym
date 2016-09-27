package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.entities.Checkin;
import br.com.gym.mylocalgym.repository.CheckinRepository;
import java.util.List;
import org.hibernate.Session;

/**
 * @author Luciano
 */
public class CheckinRepositoryImpl implements CheckinRepository {

    private Session session = HibernateUtil.session();

    @Override
    public List<Checkin> listarSolicitacao(Integer academiaId) {

        StringBuilder sql = new StringBuilder();

        sql.append("FROM Checkin c WHERE c.inAtivoInativo = true and c.idAcademia.id = :academiaId and c.solicitacaoCliente = false ");

        List<Checkin> requests = this.session.createQuery(sql.toString())
                .setParameter("academiaId", academiaId).list();

        return requests;

    }

    @Override
    public List<Checkin> getDadosCliente(Integer academiaId, Integer checkinId) {

        StringBuilder sql = new StringBuilder();

        sql.append("FROM Checkin c "
                + "WHERE c.inAtivoInativo = true "
                + "and c.idAcademia.id = :academiaId "
                + "and c.id = :id ");

        List<Checkin> requests = this.session.createQuery(sql.toString())
                .setParameter("academiaId", academiaId)
                .setParameter("id", checkinId).list();

        return requests;

    }

    @Override
    public boolean liberarCliente(Integer checkinId, boolean liberado) {

        Checkin checkin = this.buscarCheckin(checkinId);

        checkin.setSolicitacaoCliente(liberado);
        checkin.setInAtivoInativo(false);

        this.session.update(checkin);
        this.session.getTransaction().commit();

        return !checkin.getInAtivoInativo();
    }

    private Checkin buscarCheckin(Integer checkinId) {
        return (Checkin) this.session.createQuery("SELECT c FROM Checkin c WHERE c.id = :id")
                .setParameter("id", checkinId).uniqueResult();
    }

}