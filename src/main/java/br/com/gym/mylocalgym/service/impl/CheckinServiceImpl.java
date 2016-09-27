package br.com.gym.mylocalgym.service.impl;

import br.com.gym.mylocalgym.entities.Checkin;
import br.com.gym.mylocalgym.repository.CheckinRepository;
import br.com.gym.mylocalgym.service.CheckinService;
import java.util.List;
import javax.inject.Inject;

/**
 * @author Luciano
 */
public class CheckinServiceImpl implements CheckinService {

    @Inject
    private CheckinRepository checkinRepository;

    @Override
    public List<Checkin> listarSolicitacao(Integer academiaId) {

        return this.checkinRepository.listarSolicitacao(academiaId);

    }

    @Override
    public List<Checkin> getDadosCliente(Integer academiaId, Integer checkinId) {

        return this.checkinRepository.getDadosCliente(academiaId, checkinId);

    }
    
    @Override
    public boolean liberarCliente(Integer checkinId, boolean liberado){
        
        return this.checkinRepository.liberarCliente(checkinId, liberado);
        
    }

}
