package com.enrique.sevilla.domain.models;

public class Persona {
    private Integer id;
    private String nombre;
    private String apellidos;
    private String Fnacimiento;

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFnacimiento() {
        return Fnacimiento;
    }

    public void setFnacimiento(String fnacimiento) {
        Fnacimiento = fnacimiento;
    }
}
