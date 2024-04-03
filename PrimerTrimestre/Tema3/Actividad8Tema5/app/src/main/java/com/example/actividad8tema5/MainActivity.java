package com.example.actividad8tema5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button aceptarButton;
    private List<Datos> lista;
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        aceptarButton = findViewById(R.id.btnAceptar);

        // Crear una lista de elementos
        lista = new ArrayList<>();
        lista.add(new Datos("Televisión", R.drawable.tv));
        lista.add(new Datos("Teléfono Móvil", R.drawable.smartphone));
        lista.add(new Datos("Tablet", R.drawable.tablet));
        lista.add(new Datos("Ordenador fijo", R.drawable.ordenador_fijo));
        lista.add(new Datos("Ordenador portátil", R.drawable.ordenador_portatil));
        lista.add(new Datos("Reloj", R.drawable.reloj));

        // Crear el adaptador personalizado
        adaptador = new Adaptador(this, R.layout.lista_item, lista);
        listView.setAdapter(adaptador);

        // Configurar el botón de aceptar
        aceptarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarElementosSeleccionados();
            }
        });

        // Configurar la acción de hacer clic en el elemento del ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Cambiar el estado del CheckBox al hacer clic en el elemento
                CheckBox checkBox = view.findViewById(R.id.checkBox);
                boolean newState = !checkBox.isChecked();
                checkBox.setChecked(newState);
                lista.get(position).setSelected(newState);
            }
        });
    }

    // Método para mostrar los elementos seleccionados en un Toast
    private void mostrarElementosSeleccionados() {
        StringBuilder seleccionados = new StringBuilder("Elementos seleccionados: ");
        boolean hayElementosSeleccionados = false;

        for (Datos datos : lista) {
            if (datos.isSelected()) {
                hayElementosSeleccionados = true;
                seleccionados.append(datos.getNombre()).append(", ");
            }
        }

        // Verificar si hay elementos seleccionados antes de mostrar en un Toast
        if (hayElementosSeleccionados) {
            Toast.makeText(this, seleccionados.toString(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No hay elementos seleccionados", Toast.LENGTH_SHORT).show();
        }
    }
}