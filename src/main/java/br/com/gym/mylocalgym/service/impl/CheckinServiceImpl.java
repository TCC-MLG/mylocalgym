package br.com.gym.mylocalgym.service.impl;

import br.com.gym.mylocalgym.entities.CarteiraCliente;
import br.com.gym.mylocalgym.entities.Checkin;
import br.com.gym.mylocalgym.entities.Cliente;
import br.com.gym.mylocalgym.entities.Servico;
import br.com.gym.mylocalgym.parameter.CheckinParameter;
import br.com.gym.mylocalgym.repository.CheckinRepository;
import br.com.gym.mylocalgym.service.CarteiraClienteService;
import br.com.gym.mylocalgym.service.CheckinService;
import br.com.gym.mylocalgym.service.ServicoService;
import java.math.BigDecimal;
import java.util.Date;
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

    public boolean liberarCliente(CheckinParameter parameter) {

        boolean pago = this.realizarPagamento(parameter);
        
        if (pago) {

            
            
        }

        //this.checkinRepository.liberarCliente(parameter.getCheckinId(), parameter.isLiberado());
        return false;

    }

    private boolean realizarPagamento(CheckinParameter parameter) {
       
        CarteiraCliente carteira = this.serviceCliente.buscarSaldoPorId(parameter.getClienteId());

        Servico servico = this.servico.obterServico(parameter.getServicoId());
        
        boolean feito = false;
        
        if (carteira != null && servico != null) {
            
            BigDecimal saldoCliente = carteira.getSaldo();
            BigDecimal valorPlano = servico.getPreco();
            
            BigDecimal total = saldoCliente.subtract(valorPlano);

            carteira.setSaldo(total);
            
            if (total.floatValue() > 0) {
                
                feito = this.serviceCliente.inserirSaldo(carteira);
                
            }

        }
        
        
        return feito;
    }

}
