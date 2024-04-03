package com.example.ejemplo_destruiractividades;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle estadoAlmacenado) {
        super.onCreate(estadoAlmacenado);
        setContentView(R.layout.activity_main);

        if(estadoAlmacenado!=null){
            //recuperamos una variable que se almacena con el estaod
            String cadena = estadoAlmacenado.getString("VARIABLE_ALMACENADA");
            Toast.makeText(this, "Método onCreate(). Se recupera la variable almacenada: " + cadena, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle estado) {
        super.onSaveInstanceState(estado);

        //Añadimos una variable que se almacena con el estado
        estado.putString("VARIABLE_AMACENADA", "Texto guaradado");
        Toast.makeText(this, "Es estado de la actividad se ha guardado", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "El sistema ha terminado la actividad", Toast.LENGTH_SHORT).show();
    }



}