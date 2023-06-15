package com.enrique.sevilla.domain.usercase;

import com.enrique.sevilla.domain.models.Arbitro;
import com.enrique.sevilla.domain.models.ArbitroRepository;

public class AddArbitroUseCase {

    //Un caso de uso solo realiza una accion
    private ArbitroRepository arbitroRepository;

    public AddArbitroUseCase(ArbitroRepository arbitroRepository){
        this.arbitroRepository=arbitroRepository;
    }

    public void  execute(Arbitro arbitro){
        arbitroRepository.save(arbitro);
    }
}
