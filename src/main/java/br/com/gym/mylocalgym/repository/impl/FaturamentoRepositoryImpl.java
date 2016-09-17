package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.model.FaturamentoModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import br.com.gym.mylocalgym.repository.FaturamentoRepository;
import br.com.gym.mylocalgym.transformers.FaturamentoTransformer;
import java.math.BigDecimal;

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

}
