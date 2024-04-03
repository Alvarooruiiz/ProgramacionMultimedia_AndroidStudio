package com.example.actividad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button definir = findViewById(R.id.btnDefinir);
        final Button recuperar = findViewById(R.id.btnRecuperar);

        definir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Preferencias.class));
            }
        });

        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

                Log.i("Preferencias", "SO único: " + prefs.getBoolean("opcion1", false));
                Log.i("Preferencias", "SO: " + prefs.getString("opcion2", ""));
                Log.i("Preferencias", "Versión " + prefs.getString("opcion3", ""));
            }
        });
    }

}