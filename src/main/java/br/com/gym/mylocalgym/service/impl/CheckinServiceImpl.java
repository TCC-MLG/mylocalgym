package br.com.gym.mylocalgym.service.impl;

import br.com.gym.mylocalgym.entities.CarteiraAcademia;
import br.com.gym.mylocalgym.entities.CarteiraCliente;
import br.com.gym.mylocalgym.entities.Checkin;
import br.com.gym.mylocalgym.entities.Servico;
import br.com.gym.mylocalgym.parameter.CheckinParameter;
import br.com.gym.mylocalgym.repository.CheckinRepository;
import br.com.gym.mylocalgym.service.CarteiraAcademiaService;
import br.com.gym.mylocalgym.service.CarteiraClienteService;
import br.com.gym.mylocalgym.service.CheckinService;
import br.com.gym.mylocalgym.service.FaturamentoService;
import br.com.gym.mylocalgym.service.ServicoService;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * @author Luciano
 */
public class CheckinServiceImpl implements CheckinService {

    @Inject
    private CheckinRepository checkinRepository;

    @Inject
    private CarteiraClienteService serviceCliente;

    @Inject
    private CarteiraAcademiaService academiaService;

    @Inject
    private FaturamentoService faturamentoService;

    @Inject
    private ServicoService servico;

    @Override
    public List<Checkin> listarSolicitacao(Integer academiaId) {

        return this.checkinRepository.listarSolicitacao(academiaId);

    }

    @Override
    public List<Checkin> getDadosCliente(Integer academiaId, Integer checkinId) {

        return this.checkinRepository.getDadosCliente(academiaId, checkinId);

    }

    @Override
    @Transactional
    public boolean liberarCliente(CheckinParameter parameter) {

        boolean pago = this.realizarPagamento(parameter);

        if (pago) {

            this.checkinRepository.liberarCliente(parameter.getCheckinId(), parameter.isLiberado());
        
        }

        return pago;

    }

    private boolean realizarPagamento(CheckinParameter parameter) {

        CarteiraCliente carteira = this.serviceCliente.buscarSaldoPorId(parameter.getClienteId());
        Servico servico = this.servico.obterServico(parameter.getServicoId());

        boolean clienteCobrado = false;

        if (carteira != null && servico != null) {

            clienteCobrado = this.cobrarCliente(servico, carteira, parameter);

            if (clienteCobrado) {
                clienteCobrado = this.pagarAcademia(servico, carteira, parameter);
            }

            if (clienteCobrado) {
                this.faturamentoService.cadastrarHistorico(parameter.getClienteId(), parameter.getAcademiaId(), servico.getPreco());
            }
        }
        return clienteCobrado;
    }

    private boolean cobrarCliente(Servico servico, CarteiraCliente carteira, CheckinParameter parameter) {

        boolean feito = false;

        BigDecimal saldoCliente = carteira.getSaldo();
        BigDecimal valorPlano = servico.getPreco();

        BigDecimal total = saldoCliente.subtract(valorPlano);

        carteira.setSaldo(total);

        if (total.floatValue() > 0) {

            feito = this.serviceCliente.inserirSaldo(carteira);

        }
        return feito;
    }

    private boolean pagarAcademia(Servico servico, CarteiraCliente carteira, CheckinParameter parameter) {

        CarteiraAcademia academia = this.academiaService.buscarSaldoPorId(parameter.getAcademiaId());

        BigDecimal saldoAcademia = academia.getSaldo();

        BigDecimal total = saldoAcademia.add(servico.getPreco());

        boolean feito = this.academiaService.inserirSaldo(parameter.getAcademiaId(), total);

        return feito;
    }

}
