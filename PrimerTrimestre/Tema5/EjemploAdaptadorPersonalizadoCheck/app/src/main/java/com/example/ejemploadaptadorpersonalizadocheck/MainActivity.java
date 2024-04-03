package com.example.ejemploadaptadorpersonalizadocheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recuperamos el id del listado
        ListView listado = findViewById(R.id.listado);

        // Defino los datos
        ArrayList<Datos> datos = new ArrayList<>();
        datos.add(new Datos("Texto 1", false));
        datos.add(new Datos("Texto 2", true));
        datos.add(new Datos("Texto 3", false));
        datos.add(new Datos("Texto 4", true));

        // Creamos el adaptador
        Adaptador adaptador = new Adaptador(this, datos);
        listado.setAdapter(adaptador);

        // Creo el listener del botón
        final Button boton = findViewById(R.id.btnAceptar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cont=0;
                for(int i=0; i<datos.size(); i++){
                    if((datos.get(i)).isCheck()){
                        cont++;
                    }
                }

                final TextView texto = findViewById(R.id.texto);
                texto.setText("Seleccionado: " + cont);
            }
        });

    }

}