package com.example.ejemplo_ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override

    //Definimos el método callBack onStart de la Actividad
    protected void onStart() {
        super.onStart();

        //Aquí deberiamos leer los datos de la última sesión para continuar con la actividad donde la dejó el usuario
        Toast.makeText(this,"Se ejecuta el método onStart",Toast.LENGTH_SHORT).show();
    }

    //Definimos el método callback onResume de la actividad
    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "Se ejecuta el método onResume", Toast.LENGTH_SHORT).show();

    }

    //Definimos el método callback onPause de la actividad
    @Override
    protected void onPause() {
        super.onPause();

        //Aquí deberiamos guardar la información para la siguiente sesión
        Toast.makeText(this, "definimos el método onPause", Toast.LENGTH_SHORT).show();
    }

    //Definimos el método callback onStop de la actividad
    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this, "Se ejecuta el método onStop", Toast.LENGTH_SHORT).show();
    }

    //Definimos el método callback onRestart de la actividad
    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, "Se ejecuta el método onRestart", Toast.LENGTH_SHORT).show();
    }

    //Definimos el método callback onDestroy de la actividad
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "Se ejecuta el método onDestroy", Toast.LENGTH_SHORT).show();
    }
}