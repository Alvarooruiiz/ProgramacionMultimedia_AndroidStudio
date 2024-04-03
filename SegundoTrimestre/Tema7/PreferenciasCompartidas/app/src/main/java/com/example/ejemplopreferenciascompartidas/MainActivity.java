package com.example.ejemplopreferenciascompartidas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.preferenciascompartidas2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button guardar = findViewById(R.id.btnGuardar);
        final Button cargar = findViewById(R.id.btnCargar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtengo la referencia de la collección de preferencias (archivo xml)
                // donde tengo o voy a guardar las preferencias

                SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                
                // Guardamos los valores
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("nombre","Joselu");
                editor.putString("email","joselu@elmejor..com");

                // Guardamos los cambios
                editor.commit();
            }
        });

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtengo la referencia de la colección de referencias donde tengo los datos
                SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                String nombre = prefs.getString("nombre","");
                String correo = prefs.getString("email","");

                Log.i("Preferencias","Nombre " + nombre);
                Log.i("Preferencias","Correo " + correo);

            }
        });


    }
}