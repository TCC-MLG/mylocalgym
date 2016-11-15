package br.com.gym.mylocalgym.service.impl;

import br.com.gym.mylocalgym.entities.HistoricoTransacao;
import br.com.gym.mylocalgym.model.ClienteHistoricoTransacaoModel;
import br.com.gym.mylocalgym.model.FaturamentoModel;
import br.com.gym.mylocalgym.model.HistoricoAcademiaModel;
import java.util.List;
import javax.inject.Inject;
import br.com.gym.mylocalgym.repository.FaturamentoRepository;
import br.com.gym.mylocalgym.service.FaturamentoService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Luciano
 */
public class FaturamentoServiceImpl implements FaturamentoService {

    @Inject
    private FaturamentoRepository repository;

    @Override
    public List<FaturamentoModel> listarTransacoesPorPeriodo(Integer academiaId, String periodo) {
        return this.repository.listarTransacoesPorPeriodo(academiaId, periodo);
    }

    @Override
    public Map<String, BigDecimal> listarFaturamento(Integer academiaId) {

        Map<String, BigDecimal> valor = new HashMap<String, BigDecimal>();

        valor.put("semanal", this.repository.listarFaturamento(7, academiaId));
        valor.put("mensal", this.repository.listarFaturamento(30, academiaId));
        valor.put("trimestral", this.repository.listarFaturamento(90, academiaId));
        valor.put("semestral", this.repository.listarFaturamento(180, academiaId));
        valor.put("anual", this.repository.listarFaturamento(365, academiaId));

        return valor;
    }

    @Override
    public List<HistoricoTransacao> listarHistoricoClientes(Integer academiaId, LocalDate startDate, LocalDate endDate, String nome, String email, Long cpf) {

        return this.repository.listarHistoricoClientes(academiaId, startDate, endDate, nome, email, cpf);
    }

    @Override
    public boolean cadastrarHistorico(Integer clienteId, Integer academiaId, BigDecimal valor) {

        return this.repository.cadastrarHistorico(clienteId, academiaId, valor);

    }

    @Override
    public List<ClienteHistoricoTransacaoModel> listarTransacoesCliente(String idCliente, String dias) {
        return this.repository.listarTransacoesCliente(idCliente, dias);
    }

    @Override
    public List<HistoricoAcademiaModel> listarHistoricoAcademia(Integer clienteId) {
        return this.repository.listarHistoricoAcademia(clienteId);
    }

}
