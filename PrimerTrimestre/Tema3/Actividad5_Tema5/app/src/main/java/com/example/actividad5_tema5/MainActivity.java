package com.example.actividad5_tema5;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Crear algunos datos de ejemplo (nombre y teléfono de contactos)
        List<Contacto> listaContactos = new ArrayList<>();
        listaContactos.add(new Contacto("Juan Pérez", "123-456-7890"));
        listaContactos.add(new Contacto("María López", "987-654-3210"));
        // Agrega más contactos según sea necesario

        // Crear el adaptador personalizado
        AdaptadorContacto adaptador = new AdaptadorContacto(this, listaContactos);

        // Obtener la referencia al ListView en tu diseño
        ListView listViewContactos = findViewById(R.id.listViewContactos);

        // Establecer el adaptador en el ListView
        listViewContactos.setAdapter(adaptador);
    }
}