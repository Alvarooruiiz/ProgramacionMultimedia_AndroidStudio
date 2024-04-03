package com.example.tema7_actividad8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adaptador extends ArrayAdapter {
    private Usuario[] usuarios;
    public Adaptador(Context context, Usuario[] usuarios){
        super(context,R.layout.elemento,usuarios);
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Inflo el elemento
        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View elemento = mostrado.inflate(R.layout.elemento,parent,false);

        // Asigno contenido al elemento
        TextView texto0 = elemento.findViewById(R.id.miTexto1);
        texto0.setText(usuarios[position].getCodigo());

        TextView texto1 = elemento.findViewById(R.id.miTexto1);
        texto1.setText(usuarios[position].getNombre());

        TextView texto2 = elemento.findViewById(R.id.miTexto2);
        texto1.setText(usuarios[position].getApellidos());
        return elemento;
    }
}
