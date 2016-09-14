package br.com.gym.mylocalgym.repository;

import br.com.gym.mylocalgym.model.FaturamentoModel;
import java.util.List;

/**
 * @author Luciano
 */
public interface FaturamentoRepository {

    public List<FaturamentoModel> listarTransacoes();

    public List<FaturamentoModel> listarTransacoesPorPeriodo(String periodo);

}
