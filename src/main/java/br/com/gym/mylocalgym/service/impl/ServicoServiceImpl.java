package br.com.gym.mylocalgym.service.impl;

import br.com.gym.mylocalgym.entities.Servico;
import br.com.gym.mylocalgym.repository.ServicoRepository;
import br.com.gym.mylocalgym.service.ServicoService;
import java.util.List;
import javax.inject.Inject;

/**
 * @author Luciano
 */
public class ServicoServiceImpl implements ServicoService{
    
    @Inject
    private ServicoRepository servicoRepository;
    
    public List<Servico> obterServicos(Integer academiaId){
        
        return this.servicoRepository.obterServicos(academiaId);
    }
    
    public Servico obterServico(Integer servicoId){
        
        return this.servicoRepository.obterServico(servicoId);
        
    }
    
}
