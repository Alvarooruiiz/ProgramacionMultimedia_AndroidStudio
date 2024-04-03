package com.example.actividad6_tema5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adaptador extends ArrayAdapter {
    private Datos[] datos;

    public Adaptador(Context context, Datos[] datos){
        super(context,R.layout.elemento,datos);
        this.datos = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Inflo el elemento
        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View elemento = mostrado.inflate(R.layout.elemento,parent,false);

        // Asigno contenido al elemento
        ImageView img1 = elemento.findViewById(R.id.img);
        img1.setImageResource(datos[position].getImagen());

        TextView titulo = elemento.findViewById(R.id.titulo);
        titulo.setText(datos[position].getTitulo());

        TextView desc = elemento.findViewById(R.id.idDesc);
        desc.setText(datos[position].getTexto());


        return elemento;
    }
}
