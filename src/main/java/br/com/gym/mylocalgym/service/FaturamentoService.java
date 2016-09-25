package br.com.gym.mylocalgym.service;

import br.com.gym.mylocalgym.entities.HistoricoTransacao;
import br.com.gym.mylocalgym.model.FaturamentoModel;
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
    
    public List<HistoricoTransacao> listarHistoricoClientes(Integer academiaId, LocalDate startDate, LocalDate endDate, String nome, String email, Integer cpf);
    
}
