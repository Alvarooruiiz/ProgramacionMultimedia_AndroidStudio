package com.example.ejemplolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recupero el elemento del layout y defino los valores del listado
        final ListView listaOpciones = findViewById(R.id.listaOpciones);

        String[] datos = {"Opcion 1", "Opcion 2", "Opcion 3"};

        // Creo el adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,datos);

        // Asigno el adaptador
        listaOpciones.setAdapter(adaptador);

        listaOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listado, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Has hecho clic en " + datos[position], Toast.LENGTH_SHORT).show();


                // Modo 2: Obtenemos el elemento del listado
                Toast.makeText(MainActivity.this,"Has hehco clic en " + listado.getItemAtPosition(position), Toast.LENGTH_SHORT).show();

                // Modo 3: Ontenemos el elemento del adaptador
                Toast.makeText(MainActivity.this,"Has hecho clic en "+ listado.getAdapter().getItem(position), Toast.LENGTH_SHORT).show();
            }
        });


    }
}