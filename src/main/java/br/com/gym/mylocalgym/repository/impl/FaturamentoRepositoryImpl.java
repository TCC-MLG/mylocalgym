package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.entities.Academia;
import br.com.gym.mylocalgym.entities.Cliente;
import br.com.gym.mylocalgym.entities.HistoricoTransacao;
import br.com.gym.mylocalgym.model.FaturamentoModel;
import java.util.List;
import org.hibernate.Session;
import br.com.gym.mylocalgym.repository.FaturamentoRepository;
import br.com.gym.mylocalgym.transformers.FaturamentoTransformer;
import br.com.gym.mylocalgym.utils.DateUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import org.hibernate.Query;

/**
 * @author Luciano
 */
public class FaturamentoRepositoryImpl implements FaturamentoRepository {

    private Session session;

    @Override
    public List<FaturamentoModel> listarTransacoesPorPeriodo(Integer academiaId, String periodo) {

        this.session = HibernateUtil.session();

        List<FaturamentoModel> list = this.session.createSQLQuery("SELECT c.nome, h.valor, h.data_transacao "
                + "FROM mylocalgym.historico_transacao h "
                + "JOIN mylocalgym.cliente c on h.id_cliente = c.id "
                + "WHERE h.id_academia = :academiaId "
                + "AND h.data_transacao  "
                + "BETWEEN NOW() - INTERVAL :diaAcademia DAY "
                + "AND NOW()")
                .setResultTransformer(new FaturamentoTransformer())
                .setParameter("academiaId", academiaId)
                .setParameter("diaAcademia", periodo)
                .list();

        this.session.close();

        return list != null ? list : null;
    }

    @Override
    public BigDecimal listarFaturamento(Integer dias, Integer academiaId) {

        this.session = HibernateUtil.session();

        BigDecimal faturamentoMensal = (BigDecimal) this.session.createSQLQuery("SELECT sum(h.valor) "
                + "FROM mylocalgym.historico_transacao h "
                + "where h.id_academia = :academiaId "
                + "AND h.data_transacao "
                + "between NOW() - INTERVAL :dias DAY "
                + "AND NOW()").setParameter("academiaId", academiaId)
                .setParameter("dias", dias)
                .uniqueResult();

        this.session.close();

        return faturamentoMensal;

    }

    @Override
    public List<HistoricoTransacao> listarHistoricoClientes(Integer academiaId, LocalDate startDate, LocalDate endDate, String nome, String email, Integer cpf) {

        this.session = HibernateUtil.session();

        if (startDate == null && endDate == null) {
            startDate = LocalDate.now().minusDays(30);
            endDate = LocalDate.now();
        }

        StringBuilder hql = new StringBuilder();
        hql.append("FROM HistoricoTransacao h ")
                .append("where h.idAcademia.id = :academiaId ")
                .append("and h.dataTransacao ")
                .append("between :startDate ")
                .append("and :endDate ");

        if (nome != null) {
            hql.append("and h.idCliente.nome = :nome ");
        }

        if (nome != null) {
            hql.append("and h.idCliente.email = :email ");
        }

        if (cpf != null) {
            hql.append("and h.idCliente.cpf = :cpf ");
        }

        Query query = this.session.createQuery(hql.toString());

        query.setParameter("academiaId", academiaId);
        query.setParameter("startDate", DateUtil.convertStringToDate(startDate.toString()));
        query.setParameter("endDate", DateUtil.convertStringToDate(endDate.toString()));

        if (nome != null) {
            query.setParameter("nome", nome);
        }

        if (nome != null) {
            query.setParameter("email", email);
        }

        if (cpf != null) {
            query.setParameter("cpf", cpf);
        }

        List<HistoricoTransacao> list = query.list();

        this.session.close();

        return list;

    }

    public boolean cadastrarHistorico(Integer clienteId, Integer academiaId, BigDecimal valor) {

        this.session = HibernateUtil.session();

        HistoricoTransacao transacao = new HistoricoTransacao();

        Academia academia = new Academia(academiaId);
        Cliente cliente = new Cliente(clienteId);
        transacao.setDataTransacao(new Date());
        transacao.setIdAcademia(academia);
        transacao.setIdCliente(cliente);

        this.session.persist(transacao);
        
        this.session.getTransaction().commit();
        
        this.session.close();

        return transacao.getId() > 0;
    }

}
