package com.enrique.sevilla.domain.models;

public class Partido {

    private String id;
    private Equipo Elocal;
    private Equipo Evisitante;
    private Arbitro arbitro;
    private String resultado;
    private String Fpartido;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Equipo getElocal() {
        return Elocal;
    }

    public void setElocal(Equipo elocal) {
        Elocal = elocal;
    }

    public Equipo getEvisitante() {
        return Evisitante;
    }

    public void setEvisitante(Equipo evisitante) {
        Evisitante = evisitante;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getFpartido() {
        return Fpartido;
    }

    public void setFpartido(String fpartido) {
        Fpartido = fpartido;
    }
}
