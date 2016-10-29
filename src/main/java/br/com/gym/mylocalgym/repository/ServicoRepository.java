package br.com.gym.mylocalgym.repository;

import br.com.gym.mylocalgym.entities.Servico;
import java.util.List;

/**
 * @author Luciano
 */
public interface ServicoRepository {

    public List<Servico> obterServicos(Integer academiaId);

    public Servico obterServico(Integer servicoId);
    
}
