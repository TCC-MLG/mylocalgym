package br.com.gym.mylocalgym.service.impl;

import br.com.gym.mylocalgym.model.HistoricoTransacaoModel;
import br.com.gym.mylocalgym.repository.HistoricoTransacaoRepository;
import br.com.gym.mylocalgym.service.HistoricoTransacaoService;
import java.util.List;
import javax.inject.Inject;

/**
 * @author Luciano
 */
public class HistoricoTransacaoServiceImpl implements HistoricoTransacaoService {

    @Inject
    private HistoricoTransacaoRepository repository;

    @Override
    public List<HistoricoTransacaoModel> listarTransacoes() {

        return this.repository.listarTransacoes();

    }

    @Override
    public List<HistoricoTransacaoModel> listarTransacoesPorPeriodo(String periodo) {
        return this.repository.listarTransacoesPorPeriodo(periodo);
    }

}
