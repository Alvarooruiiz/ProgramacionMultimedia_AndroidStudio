package com.example.exament7_13_02_ruizenriquezalvaro;

public class Cine {
    int codigo;
    int foto;
    String nombre;

    public Cine(int foto, String nombre) {
        this.foto = foto;
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
