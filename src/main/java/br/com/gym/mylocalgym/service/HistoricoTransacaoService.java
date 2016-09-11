package br.com.gym.mylocalgym.service;

import br.com.gym.mylocalgym.model.HistoricoTransacaoModel;
import java.util.List;

/**
 * @author Luciano
 */

public interface HistoricoTransacaoService {
    
    public List<HistoricoTransacaoModel> listarTransacoes();

    public List<HistoricoTransacaoModel> listarTransacoesPorPeriodo(String periodo);
    
}
