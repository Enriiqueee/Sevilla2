package com.enrique.sevilla.data;

import com.enrique.sevilla.domain.models.ArbitroRepository;
import com.enrique.sevilla.domain.models.Arbitro;
import com.enrique.sevilla.data.local.ArbitroFileLocalDataSource;

public class ArbitroDataRepository implements ArbitroRepository {

    private ArbitroFileLocalDataSource dataSource;

    public ArbitroDataRepository (ArbitroFileLocalDataSource arbitroFileLocalDataSource){
        this.dataSource=arbitroFileLocalDataSource;
    }

    @Override
    public void save(Arbitro arbitro) {
        dataSource.save(arbitro);
    }

    @Override
    public Arbitro getById(String idArbitro) {
        return dataSource.findById(idArbitro);
    }
}
