package br.com.gym.mylocalgym.service.impl;

import br.com.gym.mylocalgym.entities.Academia;
import br.com.gym.mylocalgym.repository.AcademiaRepository;
import br.com.gym.mylocalgym.service.AcademiaService;
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

        return this.academiaRepository.cadastrar(academia);

    }

}
