package br.com.gym.mylocalgym.service;

import br.com.gym.mylocalgym.entities.Checkin;
import java.util.List;

/**
 * @author Luciano
 */
public interface CheckinService {

    public List<Checkin> listarSolicitacao(Integer academiaId);

}
