package br.com.gym.mylocalgym.service;

import br.com.gym.mylocalgym.entities.Checkin;
import br.com.gym.mylocalgym.parameter.CheckinParameter;
import java.util.List;

/**
 * @author Luciano
 */
public interface CheckinService {

    List<Checkin> listarSolicitacao(Integer academiaId);

    Checkin getDadosCliente(Integer academiaId, Integer checkinId);
    
    boolean liberarCliente(CheckinParameter parameter);
    
    Integer solicitarCheckin(Integer clienteId, Integer academiaId);
    
}
