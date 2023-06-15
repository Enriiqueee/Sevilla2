package com.enrique.sevilla.domain.models;

public interface ArbitroRepository {

    public void save(Arbitro arbitro);

    public Arbitro getById(String idArbitro);

}