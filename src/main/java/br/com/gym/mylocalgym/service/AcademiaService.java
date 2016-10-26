package br.com.gym.mylocalgym.service;

import br.com.gym.mylocalgym.entities.Academia;

/**
 * @author Matheus
 */
public interface AcademiaService {

    boolean cadastrar(Academia academia);
    
    Academia buscarAcademiaPorNome(String nomeAcademia);

}
