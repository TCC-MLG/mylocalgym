package br.com.gym.mylocalgym.service.impl;

import br.com.gym.mylocalgym.entities.Academia;
import br.com.gym.mylocalgym.repository.AcademiaRepository;
import br.com.gym.mylocalgym.service.AcademiaService;
import java.math.BigDecimal;
import javax.inject.Inject;

/**
 *
 * @author Matheus
 */
public class AcademiaServiceImpl implements AcademiaService {

    @Inject
    private AcademiaRepository academiaRepository;

    @Override
    public boolean cadastrar(Academia academia) {
        boolean cadastrou = this.academiaRepository.cadastrar(academia);

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

    @Override
    public boolean alterarServico(Integer academiaId, BigDecimal valor) {

        Academia academia = this.academiaRepository.buscarDadosAcademia(academiaId);

        academia.setValorServico(valor);

        return this.academiaRepository.alterarServico(academia);
    }

}
