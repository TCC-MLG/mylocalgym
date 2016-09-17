package br.com.gym.mylocalgym.service;

import br.com.gym.mylocalgym.model.FaturamentoModel;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Luciano
 */

public interface FaturamentoService {

    public List<FaturamentoModel> listarTransacoesPorPeriodo(Integer academiaId, String periodo);

    public Map<String, BigDecimal> listarFaturamento(Integer academiaId);
    
}
