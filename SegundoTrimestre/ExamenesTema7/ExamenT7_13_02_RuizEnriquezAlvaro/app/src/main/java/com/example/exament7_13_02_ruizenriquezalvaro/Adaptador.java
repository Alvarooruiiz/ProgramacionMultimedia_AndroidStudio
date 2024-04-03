package com.example.exament7_13_02_ruizenriquezalvaro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private ArrayList<Cine> cine;
    private Context contexto;

    public Adaptador(Context contexto, ArrayList<Cine> cines){
        super();
        this.contexto = contexto;
        this.cine = cines;
    }

    @Override
    public View getView(int posicion, View view, ViewGroup parent){
        LayoutInflater mostrado = LayoutInflater.from(contexto);
        View elemento = mostrado.inflate(R.layout.lista_peliculas, parent, false);
        ImageView imagen = elemento.findViewById(R.id.imgImagen);
        imagen.setImageResource(cine.get(posicion).getFoto());
        TextView titulo = elemento.findViewById(R.id.tvTitulo);
        titulo.setText(cine.get(posicion).getNombre());
        return elemento;
    }
    @Override
    public int getCount(){
        return cine.size();
    }
    @Override
    public Object getItem(int posicion){
        return cine.get(posicion);
    }
    @Override
    public long getItemId(int posicion){
        return posicion;
    }

}
