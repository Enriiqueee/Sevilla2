package com.enrique.sevilla.domain.models;

public class equipo {
    private Integer id;
    private String nombre;
    private String categoria;
    private jugador jugadores;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public jugador getJugadores() {
        return jugadores;
    }

    public void setJugadores(jugador jugadores) {
        this.jugadores = jugadores;
    }
}
