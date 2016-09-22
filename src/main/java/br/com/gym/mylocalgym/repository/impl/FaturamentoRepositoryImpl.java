package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.entities.HistoricoTransacao;
import br.com.gym.mylocalgym.model.FaturamentoModel;
import java.util.List;
import org.hibernate.Session;
import br.com.gym.mylocalgym.repository.FaturamentoRepository;
import br.com.gym.mylocalgym.transformers.FaturamentoTransformer;
import br.com.gym.mylocalgym.utils.DateUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.hibernate.Query;

/**
 * @author Luciano
 */
public class FaturamentoRepositoryImpl implements FaturamentoRepository {

    private Session session = HibernateUtil.session();

    @Override
    public List<FaturamentoModel> listarTransacoesPorPeriodo(Integer academiaId, String periodo) {

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

        return list != null ? list : null;
    }

    @Override
    public BigDecimal listarFaturamento(Integer dias, Integer academiaId) {

        BigDecimal faturamentoMensal = (BigDecimal) this.session.createSQLQuery("SELECT sum(h.valor) "
                + "FROM mylocalgym.historico_transacao h "
                + "where h.id_academia = :academiaId "
                + "AND h.data_transacao "
                + "between NOW() - INTERVAL :dias DAY "
                + "AND NOW()").setParameter("academiaId", academiaId)
                .setParameter("dias", dias)
                .uniqueResult();

        return faturamentoMensal;

    }

    @Override
    public List<HistoricoTransacao> listarHistoricoClientes(Integer academiaId, LocalDate startDate, LocalDate endDate) {

        if (startDate == null && endDate == null) {

            startDate = LocalDate.now().minusDays(30);
            endDate = LocalDate.now();

        }

        String hql = "FROM HistoricoTransacao h "
                + "where h.idAcademia.id = :academiaId "
                + "and h.dataTransacao "
                + "between :startDate "
                + "and :endDate ";

        Query query = this.session.createQuery(hql);

        query.setParameter("academiaId", academiaId);
        query.setParameter("startDate", DateUtil.convertStringToDate(startDate.toString()));
        query.setParameter("endDate", DateUtil.convertStringToDate(endDate.toString()));

        List<HistoricoTransacao> list = query.list();

        return list;

    }

}
