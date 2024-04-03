package com.example.practicaevaluaciontema5;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class QueVer extends AppCompatActivity {

    private PeliculaAdaptador adaptador;
    private List<Pelicula> listaPeliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quever);

        ListView listView = findViewById(R.id.lista);
        listaPeliculas = obtenerListaPeliculas();
        adaptador = new PeliculaAdaptador(this, listaPeliculas);
        listView.setAdapter(adaptador);


        registerForContextMenu(listView);

        Button btnCalcular = findViewById(R.id.btnCalcular);
        TextView tv = findViewById(R.id.tv);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int peliculasVistas = calcularPeliculasVistas();
                tv.setText("Has visto " + peliculasVistas + " películas de la lista");
            }
        });

        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QueVer.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<Pelicula> obtenerListaPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();

        peliculas.add(new Pelicula(R.drawable.oppenheimer, "Oppenheimer"));
        peliculas.add(new Pelicula(R.drawable.endgame, "EndGame"));
        peliculas.add(new Pelicula(R.drawable.clubdelalucha, "El club de la lucha"));
        peliculas.add(new Pelicula(R.drawable.interestellar, "Interestellar"));
        peliculas.add(new Pelicula(R.drawable.elpadrino, "El padrino"));


        return peliculas;
    }

    private int calcularPeliculasVistas() {
        int peliculasPorVer = 0;
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.esSeleccionada()==true) {
                peliculasPorVer++;
            }
        }
        return peliculasPorVer;
    }

    private String mostrarNombres(){
        String nombres ="";
        for(Pelicula pelicula : listaPeliculas){
            nombres+= pelicula.getNombre();
        }
        return nombres;
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Pelicula pelicula = adaptador.getItem(info.position);
        int id = item.getItemId();

        if (id == R.id.marcada) {
            pelicula.setSeleccionada(true);
            mostrarMensaje("Película marcada: " + pelicula.getNombre());
        } else if (id == R.id.desmarcada) {
            pelicula.setSeleccionada(false);
            mostrarMensaje("Película desmarcada: " + pelicula.getNombre());
        }

        adaptador.notifyDataSetChanged();
        return super.onContextItemSelected(item);
    }
}

