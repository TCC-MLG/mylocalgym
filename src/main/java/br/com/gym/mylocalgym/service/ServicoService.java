package br.com.gym.mylocalgym.service;

import br.com.gym.mylocalgym.entities.Servico;
import java.util.List;

/**
 * @author Luciano
 */
public interface ServicoService {

    public List<Servico> obterServicos(Integer academiaId);

    public Servico obterServico(Integer servicoId);

}
