package com.example.examentema3alvaro;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio3  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3);

        setContentView(R.layout.layout3);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] valores = {"1 dia", "2 dias", "3 dias", "4 dias", "5 dias", "6 dias", "7 dias"};

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,valores));
        final TextView texto = findViewById(R.id.tvSpinner);
        String valor = spinner.getSelectedItem().toString();
        texto.setText(valor);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adaptador, View view, int position, long id) {
                String cadena = (String) adaptador.getItemAtPosition(position);
                texto.setText(cadena);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
