package br.com.gym.mylocalgym.service;

import br.com.gym.mylocalgym.entities.Academia;
import java.math.BigDecimal;

/**
 * @author Matheus
 */
public interface AcademiaService {

    boolean cadastrar(Academia academia);
    
    Academia buscarAcademiaPorNome(String nomeAcademia);

    public Academia buscarDadosAcademia(Integer academiaId);

    public boolean alterarAcademia(Academia academiaEntity);

    public boolean alterarServico(Integer academiaId, BigDecimal valor);

}
