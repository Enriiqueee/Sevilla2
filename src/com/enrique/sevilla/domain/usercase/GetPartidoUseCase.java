package com.enrique.sevilla.domain.usercase;

import com.enrique.sevilla.domain.models.PartidoRepository;

public class GetPartidoUseCase {

    private PartidoRepository partidoRepository;

    public GetPartidoUseCase (PartidoRepository partidoRepository){
        this.partidoRepository=partidoRepository;
    }

    public void execute(){
        partidoRepository.getAll();
    }

}