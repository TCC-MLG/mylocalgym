package br.com.gym.mylocalgym.service.impl;

import br.com.gym.mylocalgym.entities.Academia;
import br.com.gym.mylocalgym.repository.AcademiaRepository;
import br.com.gym.mylocalgym.service.AcademiaService;
import br.com.gym.mylocalgym.service.ServicoService;
import javax.inject.Inject;

/**
 *
 * @author Matheus
 */
public class AcademiaServiceImpl implements AcademiaService {

    @Inject
    private AcademiaRepository academiaRepository;

    @Inject
    private ServicoService servicoService;

    @Override
    public boolean cadastrar(Academia academia) {
        boolean cadastrou = this.academiaRepository.cadastrar(academia);

        if (cadastrou) {
            
            this.servicoService.criarServicoPadrao(academia.getId());

        }

        return cadastrou;

    }

    @Override
    public Academia buscarAcademiaPorNome(String nomeAcademia) {

        return this.academiaRepository.buscarAcademiaPorNome(nomeAcademia);
    }

    @Override
    public Academia buscarDadosAcademia(Integer academiaId) {
        
        return this.academiaRepository.buscarDadosAcademia(academiaId);
    }

    @Override
    public boolean alterarAcademia(Academia academiaEntity) {
        
        return this.academiaRepository.alterarAcademia(academiaEntity);
    }


}
