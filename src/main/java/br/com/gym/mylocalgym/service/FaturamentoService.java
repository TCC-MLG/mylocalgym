package br.com.gym.mylocalgym.service;

import br.com.gym.mylocalgym.model.FaturamentoModel;
import java.util.List;

/**
 * @author Luciano
 */

public interface FaturamentoService {
    
    public List<FaturamentoModel> listarTransacoes();

    public List<FaturamentoModel> listarTransacoesPorPeriodo(String periodo);
    
}
