package com.example.tema7_actividad8;

public class Usuario {
    private String codigo;
    private String nombre;
    private String apellidos;

    public Usuario(String codigo, String nombre, String apellidos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
}
