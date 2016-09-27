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
    
    public List<Checkin> listarSolicitacao(Integer academiaId){
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("FROM Checkin c WHERE c.inAtivoInativo = true and c.idAcademia.id = :academiaId and c.solicitacaoCliente = false ");
        
        List<Checkin> requests = this.session.createQuery(sql.toString())
                .setParameter("academiaId", academiaId).list();
        
        return requests;
        
    }

}
