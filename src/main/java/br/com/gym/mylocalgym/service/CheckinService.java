package br.com.gym.mylocalgym.service;

import br.com.gym.mylocalgym.entities.Checkin;
import br.com.gym.mylocalgym.parameter.CheckinParameter;
import java.util.List;

/**
 * @author Luciano
 */
public interface CheckinService {

    public List<Checkin> listarSolicitacao(Integer academiaId);

    Checkin getDadosCliente(Integer academiaId, Integer checkinId);
    
    public boolean liberarCliente(CheckinParameter parameter);
    
}
