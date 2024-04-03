package com.example.practicaevaluaciontema5;

public class Pelicula {
    private boolean seleccionada;
    private int imagenResId;
    private String nombre;

    public Pelicula(int imagenResId, String nombre) {
        this.seleccionada = false;
        this.imagenResId = imagenResId;
        this.nombre = nombre;
    }

    public boolean esSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(boolean seleccionada) {
        this.seleccionada = seleccionada;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    public String getNombre() {
        return nombre;
    }
}