package com.enrique.sevilla.domain.usercase;

import com.enrique.sevilla.domain.models.Equipo;
import com.enrique.sevilla.domain.models.EquipoRepository;
public class AddEquiposUseCase {

    private EquipoRepository equipoRepository;

    public AddEquiposUseCase(EquipoRepository equipoRepository){
        this.equipoRepository=equipoRepository;
    }

    public void execute(Equipo equipo) {
        equipoRepository.save(equipo);
    }
}
