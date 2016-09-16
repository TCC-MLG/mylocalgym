package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.entities.HistoricoTransacao;
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
import java.math.BigDecimal;

/**
 * @author Luciano
 */
public class FaturamentoRepositoryImpl implements FaturamentoRepository {

    private Session session = HibernateUtil.session();

    @Override
    public List<FaturamentoModel> listarTransacoes() {

        List<HistoricoTransacao> list = this.session.createQuery("SELECT h FROM HistoricoTransacao h").list();

        List<FaturamentoModel> parameter = new ArrayList<FaturamentoModel>();

        for (HistoricoTransacao historicoTransacao : list) {
            parameter.add(historicoTransacao.convert());
        }

        return list != null ? parameter : null;

    }

    @Override
    public List<FaturamentoModel> listarTransacoesPorPeriodo(String periodo) {

        Date data = this.convertStringToDate(periodo);

        List<HistoricoTransacao> list = this.session.createQuery("SELECT h FROM HistoricoTransacao h WHERE h.dataTransacao = :dataTransacao")
                .setParameter("dataTransacao", data)
                .list();

        List<FaturamentoModel> parameter = new ArrayList<FaturamentoModel>();

        for (HistoricoTransacao historicoTransacao : list) {
            parameter.add(historicoTransacao.convert());
        }

        return list != null ? parameter : null;
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

    private Date convertStringToDate(String periodo) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        try {
            data = new Date(format.parse(periodo).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(FaturamentoRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

}
