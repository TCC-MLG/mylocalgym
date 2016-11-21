package br.com.gym.mylocalgym.repository;

import br.com.gym.mylocalgym.entities.Academia;



/**
 *
 * @author Matheus
 */
public interface AcademiaRepository {

    boolean cadastrar(Academia academia);
    
    Academia buscarAcademiaPorNome(String nomeAcademia);

    public Academia buscarDadosAcademia(Integer academiaId);

    public boolean alterarAcademia(Academia academiaEntity);

}
