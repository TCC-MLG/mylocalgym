package br.com.gym.mylocalgym.repository;

import br.com.gym.mylocalgym.entities.HistoricoTransacao;
import br.com.gym.mylocalgym.model.ClienteHistoricoTransacaoModel;
import br.com.gym.mylocalgym.model.FaturamentoModel;
import br.com.gym.mylocalgym.model.HistoricoAcademiaModel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Luciano
 */
public interface FaturamentoRepository {

    List<FaturamentoModel> listarTransacoesPorPeriodo(Integer academiaId, String periodo);

    BigDecimal listarFaturamento(Integer dias, Integer academiaId);

    List<HistoricoTransacao> listarHistoricoClientes(Integer academiaId, LocalDate startDate, LocalDate endDate, String nome, String email, Integer cpf);

    boolean cadastrarHistorico(Integer clienteId, Integer academiaId, BigDecimal valor);
    
    List<ClienteHistoricoTransacaoModel> listarTransacoesCliente(String idCliente, String dias);
    
    List<HistoricoAcademiaModel> listarHistoricoAcademia(Integer clienteId);

}
