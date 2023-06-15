package com.enrique.sevilla.domain.models;

import java.util.List;

public interface PartidoRepository {

    public void save(Partido partidos);

    public List<Partido> getAll();

    public void delete(String idPartido);
}
