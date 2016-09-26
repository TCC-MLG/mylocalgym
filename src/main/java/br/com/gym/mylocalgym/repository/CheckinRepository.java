package br.com.gym.mylocalgym.repository;

import br.com.gym.mylocalgym.entities.Checkin;
import java.util.List;

/**
 * @author Luciano
 */
public interface CheckinRepository {

    public List<Checkin> listarSolicitacao(Integer academiaId);

}
