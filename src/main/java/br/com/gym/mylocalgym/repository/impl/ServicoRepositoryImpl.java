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

    private Session session;

    @Override
    public List<Servico> obterServicos(Integer academiaId) {

        this.session = HibernateUtil.session();
        String sql = "SELECT s FROM Servico s WHERE s.idAcademia.id = :idAcademia and s.padrao = true";

        List<Servico> servicos = this.session.createQuery(sql)
                .setParameter("idAcademia", academiaId)
                .list();

        this.session.close();

        return servicos;
    }

    @Override
    public Servico obterServico(Integer servicoId) {
        this.session = HibernateUtil.session();
        String sql = "FROM Servico s WHERE s.id = :servicoId and s.padrao = true";

        Servico servico = (Servico) this.session.createQuery(sql)
                .setParameter("servicoId", servicoId)
                .uniqueResult();
        this.session.close();
        return servico;

    }

    public boolean criarServicoPadrao(Integer academiaId) {
        
        this.session = HibernateUtil.session();
        String sql = " insert into mylocalgym.servico "
                + " (nome, preco, tipo, id_academia, padrao) "
                + " values ('padrao', 12.00, 'B', :academiaId, 1) ";

        Integer servico = this.session.createSQLQuery(sql)
                .setParameter("academiaId", academiaId)
                .executeUpdate();
        this.session.getTransaction().commit();
        this.session.close();

        return servico > 0;

    }

}
