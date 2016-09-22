package br.com.gym.mylocalgym.repository;

import br.com.gym.mylocalgym.entities.HistoricoTransacao;
import br.com.gym.mylocalgym.model.FaturamentoModel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Luciano
 */
public interface FaturamentoRepository {

    public List<FaturamentoModel> listarTransacoesPorPeriodo(Integer academiaId, String periodo);

    public BigDecimal listarFaturamento(Integer dias, Integer academiaId);
    
    public List<HistoricoTransacao> listarHistoricoClientes(Integer academiaId, LocalDate startDate, LocalDate endDate, String nome, String email);

}
