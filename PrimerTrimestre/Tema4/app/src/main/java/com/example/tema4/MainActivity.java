package com.example.tema4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.miSpinnerValores, android.R.layout.simple_spinner_item);
        final Spinner miSpinner = findViewById(R.id.miSpinner);
        miSpinner.setAdapter(adapter);
        final TextView tv = findViewById(R.id.ejemplo);

        final ImageButton btn = findViewById(R.id.imgBtn);

        final Intent intentTruco = new Intent(MainActivity.this, Truco.class);
        final Intent intentTrato = new Intent(MainActivity.this, Trato.class);


        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String cadena =(String)adapterView.getItemAtPosition(i);

                if(cadena.equals("Truco")){
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(intentTruco);
                        }
                    });
                } else if (cadena.equals("Trato")) {
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(intentTrato);
                        }
                    });
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}