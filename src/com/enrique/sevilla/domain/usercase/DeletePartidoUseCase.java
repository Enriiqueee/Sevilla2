package com.enrique.sevilla.domain.usercase;

import com.enrique.sevilla.domain.models.PartidoRepository;
import com.enrique.sevilla.domain.models.Partido;
public class DeletePartidoUseCase {

    private PartidoRepository partidoRepository;

    public DeletePartidoUseCase(PartidoRepository partidoRepository){
        this.partidoRepository=partidoRepository;
    }

    public void execute(String partidoId){
        partidoRepository.delete(partidoId);
    }
}
