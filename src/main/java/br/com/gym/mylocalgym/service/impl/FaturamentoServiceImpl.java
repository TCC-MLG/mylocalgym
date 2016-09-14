package br.com.gym.mylocalgym.service.impl;

import br.com.gym.mylocalgym.model.FaturamentoModel;
import java.util.List;
import javax.inject.Inject;
import br.com.gym.mylocalgym.repository.FaturamentoRepository;
import br.com.gym.mylocalgym.service.FaturamentoService;

/**
 * @author Luciano
 */
public class FaturamentoServiceImpl implements FaturamentoService {

    @Inject
    private FaturamentoRepository repository;

    @Override
    public List<FaturamentoModel> listarTransacoes() {

        return this.repository.listarTransacoes();

    }

    @Override
    public List<FaturamentoModel> listarTransacoesPorPeriodo(String periodo) {
        return this.repository.listarTransacoesPorPeriodo(periodo);
    }

}
