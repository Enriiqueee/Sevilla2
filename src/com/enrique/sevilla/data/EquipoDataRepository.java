package com.enrique.sevilla.data;

import com.enrique.sevilla.data.local.EquipoFileLocalDataSource;
import com.enrique.sevilla.domain.models.Equipo;
import com.enrique.sevilla.domain.models.EquipoRepository;

public class EquipoDataRepository implements EquipoRepository {

    private EquipoFileLocalDataSource dataSource;

    public EquipoDataRepository (EquipoFileLocalDataSource equipoFileLocalDataSource){
        this.dataSource=equipoFileLocalDataSource;
    }


    @Override
    public void save(Equipo equipo) {
        dataSource.save(equipo);
    }

    @Override
    public Equipo getByID(String idEquipo) {
        return dataSource.findById(idEquipo);
    }
}
