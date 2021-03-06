package br.com.gym.mylocalgym.service.impl;

import br.com.gym.mylocalgym.entities.CarteiraAcademia;
import br.com.gym.mylocalgym.entities.CarteiraCliente;
import br.com.gym.mylocalgym.entities.Checkin;
import br.com.gym.mylocalgym.parameter.CheckinParameter;
import br.com.gym.mylocalgym.repository.CheckinRepository;
import br.com.gym.mylocalgym.service.CarteiraAcademiaService;
import br.com.gym.mylocalgym.service.CarteiraClienteService;
import br.com.gym.mylocalgym.service.CheckinService;
import br.com.gym.mylocalgym.service.FaturamentoService;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;

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

    @Override
    public List<Checkin> listarSolicitacao(Integer academiaId) {

        return this.checkinRepository.listarSolicitacao(academiaId);
    }

    @Override
    public Checkin getDadosCliente(Integer academiaId, Integer checkinId) {

        return this.checkinRepository.getDadosCliente(academiaId, checkinId);
    }

    @Override
    public boolean liberarCliente(CheckinParameter parameter) {

        boolean pago = this.realizarPagamento(parameter);
        if (pago) {
            this.checkinRepository.liberarCliente(parameter.getCheckinId(), parameter.isLiberado());
        }

        return pago;
    }

    private boolean realizarPagamento(CheckinParameter parameter) {

        CarteiraCliente carteira = this.serviceCliente.buscarSaldoPorId(parameter.getClienteId());

        boolean clienteCobrado = false;

        if (carteira != null) {

            clienteCobrado = this.cobrarCliente(carteira, parameter);

            if (clienteCobrado) {
                clienteCobrado = this.pagarAcademia(parameter);
            }

            if (clienteCobrado) {
                this.faturamentoService.cadastrarHistorico(parameter.getClienteId(), parameter.getAcademiaId(), parameter.getValorServico());
            }
        }
        return clienteCobrado;
    }

    private boolean cobrarCliente(CarteiraCliente carteira, CheckinParameter parameter) {

        boolean feito = false;

        BigDecimal saldoCliente = carteira.getSaldo();
        BigDecimal valorPlano = parameter.getValorServico();

        BigDecimal total = saldoCliente.subtract(valorPlano);

        carteira.setSaldo(total);

        if (total.floatValue() > 0) {

            feito = this.serviceCliente.inserirSaldo(carteira);

        }
        return feito;
    }

    private boolean pagarAcademia(CheckinParameter parameter) {

        CarteiraAcademia academia = this.academiaService.buscarSaldoPorId(parameter.getAcademiaId());
        BigDecimal saldoAcademia;

        if (academia == null) {
            saldoAcademia = new BigDecimal(0);
        } else {
            saldoAcademia = academia.getSaldo();
        }
        BigDecimal total = saldoAcademia.add(parameter.getValorServico());

        boolean feito = this.academiaService.inserirSaldo(parameter.getAcademiaId(), total);

        return feito;
    }

    @Override
    public Integer solicitarCheckin(Integer clienteId, Integer academiaId) {
        return this.checkinRepository.solicitarCheckin(clienteId, academiaId);
    }

    public boolean verificarSolicitacao(Integer clienteId, Integer checkinId) {
        return this.checkinRepository.verificarSolicitacao(clienteId, checkinId);
    }

}
