package com.example.actividad6_tema5;

import android.media.Image;

public class Datos {

    int imagen;
    String titulo;
    String texto;
    boolean cositas;

    public Datos(int imagen, String titulo, String texto, boolean cositas) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.texto = texto;
        this.cositas = cositas;
    }

    public int getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }

    public boolean isCositas() {
        return cositas;
    }
}
