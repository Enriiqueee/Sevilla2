package com.enrique.sevilla.domain.usercase;

import com.enrique.sevilla.domain.models.Partido;
import com.enrique.sevilla.domain.models.PartidoRepository;

public class AddPartidosUseCase {

    private PartidoRepository partidoRepository;

    public AddPartidosUseCase (PartidoRepository partidoRepository){
        this.partidoRepository=partidoRepository;
    }

    public void execute(Partido partido){
        partidoRepository.save(partido);
    }
}
