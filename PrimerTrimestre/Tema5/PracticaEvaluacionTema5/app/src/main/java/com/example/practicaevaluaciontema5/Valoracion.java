package com.example.practicaevaluaciontema5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Valoracion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.valoracion);

        String[] datos = {"Seleccione una opción","Cuenta personal", "Cuenta de familiar" , "Cuenta estudiante"};
        Spinner spinner = findViewById(R.id.spnTipoCuenta);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos));

        final Button btnEnviar = findViewById(R.id.btnEnviar);
        final TextView txtNom = findViewById(R.id.txtNombreUsuario);
        final TextView txtRese = findViewById(R.id.txtResena);
        final RatingBar miRatin = findViewById(R.id.miRating);
        final Switch switchRating = findViewById(R.id.switchRating);


        switchRating.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                miRatin.setVisibility(View.VISIBLE);
            } else {
                miRatin.setVisibility(View.INVISIBLE);
            }
        });


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtRese.setText("");
                txtNom.setText("");
                miRatin.setRating(2);
                Toast.makeText(Valoracion.this,"Eviado corrextamente",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Valoracion.this, MainActivity.class);
                startActivity(intent);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Valoracion.this,"Se ha seleccionado el tipo de cuenta",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
