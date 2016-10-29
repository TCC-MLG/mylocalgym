package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.entities.Servico;
import br.com.gym.mylocalgym.repository.ServicoRepository;
import java.util.List;
import org.hibernate.Session;

/**
 * @author Luciano
 */
public class ServicoRepositoryImpl implements ServicoRepository {

    private Session session = HibernateUtil.session();

    @Override
    public List<Servico> obterServicos(Integer academiaId) {

        String sql = "SELECT s FROM Servico s WHERE s.idAcademia.id = :idAcademia";

        List<Servico> servicos = this.session.createQuery(sql)
                .setParameter("idAcademia", academiaId)
                .list();

        return servicos;
    }

    @Override
    public Servico obterServico(Integer servicoId) {

        String sql = "FROM Servico s WHERE s.id = :servicoId ";

        Servico servico = (Servico) this.session.createQuery(sql)
                .setParameter("servicoId", servicoId)
                .uniqueResult();

        return servico;

    }

}
