package br.com.gym.mylocalgym.repository;

import br.com.gym.mylocalgym.model.HistoricoTransacaoModel;
import java.util.List;

/**
 * @author Luciano
 */
public interface HistoricoTransacaoRepository {

    public List<HistoricoTransacaoModel> listarTransacoes();

    public List<HistoricoTransacaoModel> listarTransacoesPorPeriodo(String periodo);

}
