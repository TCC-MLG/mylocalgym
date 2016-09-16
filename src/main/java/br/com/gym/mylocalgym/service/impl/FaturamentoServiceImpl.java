package br.com.gym.mylocalgym.service.impl;

import br.com.gym.mylocalgym.model.FaturamentoModel;
import java.util.List;
import javax.inject.Inject;
import br.com.gym.mylocalgym.repository.FaturamentoRepository;
import br.com.gym.mylocalgym.service.FaturamentoService;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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

    @Override
    public Map<String, BigDecimal> listarFaturamento(Integer academiaId) {

        Map<String, BigDecimal> valor = new HashMap<String, BigDecimal>();

        valor.put("semanal", this.repository.listarFaturamento(7, academiaId));
        valor.put("mensal", this.repository.listarFaturamento(30, academiaId));
        valor.put("Trimestral", this.repository.listarFaturamento(90, academiaId));
        valor.put("Semestral", this.repository.listarFaturamento(180, academiaId));
        valor.put("Anual", this.repository.listarFaturamento(365, academiaId));

        return valor;
    }

}
