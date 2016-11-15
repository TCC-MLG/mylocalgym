package br.com.gym.mylocalgym.service;

import br.com.gym.mylocalgym.entities.HistoricoTransacao;
import br.com.gym.mylocalgym.model.ClienteHistoricoTransacaoModel;
import br.com.gym.mylocalgym.model.FaturamentoModel;
import br.com.gym.mylocalgym.model.HistoricoAcademiaModel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author Luciano
 */
public interface FaturamentoService {

    public List<FaturamentoModel> listarTransacoesPorPeriodo(Integer academiaId, String periodo);

    public Map<String, BigDecimal> listarFaturamento(Integer academiaId);

    public List<HistoricoTransacao> listarHistoricoClientes(Integer academiaId, LocalDate startDate, LocalDate endDate, String nome, String email, Long cpf);

    public boolean cadastrarHistorico(Integer clienteId, Integer academiaId, BigDecimal valor);

    public List<ClienteHistoricoTransacaoModel> listarTransacoesCliente(String idCliente, String dias);
    
    public List<HistoricoAcademiaModel> listarHistoricoAcademia(Integer clienteId);

}
