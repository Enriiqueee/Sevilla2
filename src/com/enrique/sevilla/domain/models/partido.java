package com.enrique.sevilla.domain.models;

public class partido {

    private Integer id;
    private equipo Elocal;
    private equipo Evisitante;
    private arbitro arbitro;
    private String resultado;
    private String Fpartido;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public equipo getElocal() {
        return Elocal;
    }

    public void setElocal(equipo elocal) {
        Elocal = elocal;
    }

    public equipo getEvisitante() {
        return Evisitante;
    }

    public void setEvisitante(equipo evisitante) {
        Evisitante = evisitante;
    }

    public arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(arbitro arbitro) {
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
