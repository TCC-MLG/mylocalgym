package br.com.gym.mylocalgym.repository.impl;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.entities.Academia;
import br.com.gym.mylocalgym.entities.Cliente;
import br.com.gym.mylocalgym.entities.HistoricoTransacao;
import br.com.gym.mylocalgym.model.ClienteHistoricoTransacaoModel;
import br.com.gym.mylocalgym.model.FaturamentoModel;
import br.com.gym.mylocalgym.model.HistoricoAcademiaModel;
import java.util.List;
import org.hibernate.Session;
import br.com.gym.mylocalgym.repository.FaturamentoRepository;
import br.com.gym.mylocalgym.transformers.FaturamentoTransformer;
import br.com.gym.mylocalgym.utils.DateUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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
    public List<HistoricoTransacao> listarHistoricoClientes(Integer academiaId, LocalDate startDate, LocalDate endDate, String nome, String email, Long cpf) {

        this.session = HibernateUtil.session();

        if (startDate == null && endDate == null) {
            startDate = LocalDate.now().minusDays(300);
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

        if (email != null) {
            hql.append("and h.idCliente.email = :email ");
        }

        if (cpf != null) {
            hql.append("and h.idCliente.cpf = :cpf ");
        }
        
        hql.append(" order by h.dataTransacao desc ");

        Query query = this.session.createQuery(hql.toString());

        query.setParameter("academiaId", academiaId);
        query.setParameter("startDate", DateUtil.convertStringToDate(startDate.toString()));
        query.setParameter("endDate", DateUtil.convertStringToDate(endDate.toString()));

        if (nome != null) {
            query.setParameter("nome", nome);
        }

        if (email != null) {
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
        transacao.setValor(valor);

        this.session.persist(transacao);

        this.session.getTransaction().commit();

        this.session.close();

        return transacao.getId() > 0;
    }

    public List<ClienteHistoricoTransacaoModel> listarTransacoesCliente(String idCliente, String dias) {

        this.session = HibernateUtil.session();

        LocalDate periodo = LocalDate.now().minusDays(Integer.valueOf(dias));
        LocalDate agora = LocalDate.now();

        StringBuilder hql = new StringBuilder();

        hql.append(" FROM HistoricoTransacao h ")
                .append(" WHERE h.idCliente.id = :idCliente ")
                .append(" and h.dataTransacao ")
                .append(" between :periodo ")
                .append(" and :agora ")
                .append(" order by h.dataTransacao desc ");

        List<HistoricoTransacao> list = this.session.createQuery(hql.toString())
                .setParameter("idCliente", Integer.valueOf(idCliente))
                .setParameter("periodo", DateUtil.convertStringToDate(periodo.toString()))
                .setParameter("agora", DateUtil.convertStringToDate(agora.toString())).list();

        this.session.close();

        List<ClienteHistoricoTransacaoModel> models = new ArrayList<>();

        for (HistoricoTransacao historicoTransacao : list) {

            models.add(historicoTransacao.convertToHistoricoCliente());

        }

        return list != null ? models : null;
    }

    @Override
    public List<HistoricoAcademiaModel> listarHistoricoAcademia(Integer clienteId) {

        this.session = HibernateUtil.session();
        try {
            List<HistoricoTransacao> list = this.session.createQuery("FROM HistoricoTransacao h WHERE h.idCliente.id = :clienteId order by h.dataTransacao desc")
                    .setParameter("clienteId", clienteId)
                    .list();

            List<HistoricoAcademiaModel> academiaModels = new ArrayList<>();

            if (list != null) {
                for (HistoricoTransacao academiaModel : list) {
                    academiaModels.add(academiaModel.convertToHistoricoAcademia());
                }
            }
            this.session.close();
            return academiaModels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
