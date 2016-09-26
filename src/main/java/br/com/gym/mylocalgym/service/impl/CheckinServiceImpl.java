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

    public List<Checkin> listarSolicitacao(Integer academiaId) {

        return checkinRepository.listarSolicitacao(academiaId);

    }

}
