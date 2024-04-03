package com.example.practicaevaluaciontema5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PeliculaAdaptador extends ArrayAdapter<Pelicula> {

    public PeliculaAdaptador(Context context, List<Pelicula> peliculas) {
        super(context, 0, peliculas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pelicula pelicula = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_pelicula, parent, false);
        }

        CheckBox checkBox = convertView.findViewById(R.id.checkboxPelicula);
        ImageView imageView = convertView.findViewById(R.id.imageViewPelicula);
        TextView textView = convertView.findViewById(R.id.textViewPelicula);

        checkBox.setChecked(pelicula.esSeleccionada());
        imageView.setImageResource(pelicula.getImagenResId());
        textView.setText(pelicula.getNombre());

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox = (CheckBox) v;
                Pelicula pelicula = getItem(position);
                pelicula.setSeleccionada(checkBox.isChecked());
            }
        });

        return convertView;
    }
}