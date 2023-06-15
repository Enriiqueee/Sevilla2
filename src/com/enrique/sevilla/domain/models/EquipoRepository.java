package com.enrique.sevilla.domain.models;

public interface EquipoRepository {

    public void save(Equipo equipos);

    public Equipo getByID(String idEquipo);

}
