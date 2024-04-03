package com.example.tema7_ejercicio1_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button guardar = findViewById(R.id.btnGuardar);
        final Button cargar = findViewById(R.id.btnRecuperar);
        final EditText et1 = findViewById(R.id.et1);
        final EditText et2 = findViewById(R.id.et2);
        final TextView tv1 = findViewById(R.id.tv1);
        final TextView tv2 = findViewById(R.id.tv2);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("texto1", et1.getText().toString());
                editor.putString("texto2", et2.getText().toString());
                editor.commit();
            }
        });

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtengo la referencia de la preferencia
                SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                String nombre = prefs.getString("texto1","");
                String correo = prefs.getString("texto2","");

                tv1.setText(nombre);
                tv2.setText(correo);

            }
        });
    }
}