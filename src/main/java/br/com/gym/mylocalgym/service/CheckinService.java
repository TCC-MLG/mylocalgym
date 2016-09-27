package br.com.gym.mylocalgym.service;

import br.com.gym.mylocalgym.entities.Checkin;
import java.util.List;

/**
 * @author Luciano
 */
public interface CheckinService {

    public List<Checkin> listarSolicitacao(Integer academiaId);

    public List<Checkin> getDadosCliente(Integer academiaId, Integer checkinId);
    
    public boolean liberarCliente(Integer checkinId, boolean liberado);
    
}
