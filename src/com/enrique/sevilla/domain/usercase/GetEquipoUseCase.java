package com.enrique.sevilla.domain.usercase;

import com.enrique.sevilla.domain.models.Equipo;
import com.enrique.sevilla.domain.models.EquipoRepository;

public class GetEquipoUseCase {

    private EquipoRepository equipoRepository;

    public  GetEquipoUseCase (EquipoRepository equipoRepository){
        this.equipoRepository=equipoRepository;
    }

    public Equipo execute(String equipoId){
        return equipoRepository.getByID(equipoId);
    }

}
