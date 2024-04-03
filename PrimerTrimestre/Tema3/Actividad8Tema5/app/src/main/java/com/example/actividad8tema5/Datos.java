package com.example.actividad8tema5;

import android.widget.CheckBox;

public class Datos{
    private String nombre;
    private int imagenResId;
    private boolean selected;

    public Datos(String nombre, int imagenResId) {
        this.nombre = nombre;
        this.imagenResId = imagenResId;
        this.selected = false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}