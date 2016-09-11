package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.entities.HistoricoTransacao;
import br.com.gym.mylocalgym.model.HistoricoTransacaoModel;
import br.com.gym.mylocalgym.repository.HistoricoTransacaoRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 * @author Luciano
 */
public class HistoricoTransacaoRepositoryImpl implements HistoricoTransacaoRepository {

    private Session session = HibernateUtil.session();

    @Override
    public List<HistoricoTransacaoModel> listarTransacoes() {

        List<HistoricoTransacao> list = this.session.createQuery("SELECT h FROM HistoricoTransacao h").list();

        List<HistoricoTransacaoModel> parameter = new ArrayList<HistoricoTransacaoModel>();

        for (HistoricoTransacao historicoTransacao : list) {
            parameter.add(historicoTransacao.convert());
        }

        return list != null ? parameter : null;

    }

    @Override
    public List<HistoricoTransacaoModel> listarTransacoesPorPeriodo(String periodo) {

        Date data = this.convertStringToDate(periodo);

        List<HistoricoTransacao> list = this.session.createQuery("SELECT h FROM HistoricoTransacao h WHERE h.dataTransacao = :dataTransacao")
                .setParameter("dataTransacao", data)
                .list();

        List<HistoricoTransacaoModel> parameter = new ArrayList<HistoricoTransacaoModel>();

        for (HistoricoTransacao historicoTransacao : list) {
            parameter.add(historicoTransacao.convert());
        }

        return list != null ? parameter : null;
    }

    private Date convertStringToDate(String periodo) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        try {
            data = new Date(format.parse(periodo).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(HistoricoTransacaoRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

}
