package com.enrique.sevilla.domain.usercase;

import com.enrique.sevilla.domain.models.Arbitro;
import com.enrique.sevilla.domain.models.ArbitroRepository;
public class GetArbitroUseCase {

    private ArbitroRepository arbitroRepository;

    public GetArbitroUseCase(ArbitroRepository arbitroRepository){
        this.arbitroRepository=arbitroRepository;
    }

    public Arbitro execute(String arbitroId){
        return arbitroRepository.getById(arbitroId);
    }
}
