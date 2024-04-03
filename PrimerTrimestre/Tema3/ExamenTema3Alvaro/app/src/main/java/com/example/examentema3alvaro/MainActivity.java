package com.example.examentema3alvaro;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout1);
        final Button btnAcceder = findViewById(R.id.btnAcceder);
        final EditText etNombre = findViewById(R.id.etNombre);
        final EditText etContraseña = findViewById(R.id.etContraseña);

        ActivityResultLauncher resultLauncher =registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == Activity.RESULT_OK) {
                Intent intent = result.getData();


            }
            }
        });

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                etNombre.setVisibility(View.VISIBLE);
                etContraseña.setVisibility(View.VISIBLE);
                btnAcceder.setVisibility(View.VISIBLE);
            }
        }, 3000);



        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                String contraseña = etContraseña.getText().toString();

                if (nombre.equals("") || contraseña.equals("")) {

                    Toast.makeText(MainActivity.this, "Error! Introduzca el usuario y la clave", Toast.LENGTH_SHORT).show();

                } else if (nombre.equals("") && contraseña.equals("")) {
                    Toast.makeText(MainActivity.this, "Error! Introduzca el usuario y la clave", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "Hola " + nombre + ". Accediendo a la app", Toast.LENGTH_SHORT).show();

                }
                //Llamo a la nueva actividad y le paso datos
                    Intent intent_ejercicio2 = new Intent(MainActivity.this,Ejercicio2.class);
                startActivity(intent_ejercicio2);
//                resultLauncher.launch(intent_ejercicio2);

            }
        });
        }
}