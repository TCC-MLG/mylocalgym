package br.com.gym.mylocalgym.repository;

import br.com.gym.mylocalgym.entities.Checkin;
import java.util.List;

/**
 * @author Luciano
 */
public interface CheckinRepository {

    List<Checkin> listarSolicitacao(Integer academiaId);
    
    Checkin getDadosCliente(Integer academiaId, Integer checkinId);
    
    boolean liberarCliente(Integer checkinId, boolean liberado);
    
    Integer solicitarCheckin(Integer clienteId, Integer academiaId);
    
    boolean verificarSolicitacao(Integer clienteId, Integer checkinId);

}
