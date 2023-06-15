package com.enrique.sevilla.data;

import com.enrique.sevilla.data.local.PartidoFileLocalDataSource;
import com.enrique.sevilla.domain.models.Arbitro;
import com.enrique.sevilla.domain.models.ArbitroRepository;
import com.enrique.sevilla.domain.models.Partido;
import com.enrique.sevilla.domain.models.PartidoRepository;

import java.util.List;

public class PartidoDataRepository implements PartidoRepository {

    private PartidoFileLocalDataSource dataSource;

    public PartidoDataRepository(PartidoFileLocalDataSource partidoFileLocalDataSource){
        this.dataSource=partidoFileLocalDataSource;
    }


    @Override
    public void save(Partido partidos) {
        dataSource.save(partidos);
    }

    @Override
    public List<Partido> getAll() {
        return dataSource.findAll();
    }

    @Override
    public void delete(String idPartido) {
        dataSource.delete(idPartido);
    }
}
