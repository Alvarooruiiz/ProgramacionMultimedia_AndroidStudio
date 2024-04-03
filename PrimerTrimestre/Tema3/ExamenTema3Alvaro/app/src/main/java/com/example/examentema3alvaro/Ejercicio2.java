package com.example.examentema3alvaro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        int botonSeleccionado = 0;

        final Button btn1 = findViewById(R.id.boton1);
        final Button btn2 = findViewById(R.id.boton2);
        final Button btn3 = findViewById(R.id.boton3);
        final Button btnSiguiente = findViewById(R.id.btnSiguiente);

        ActivityResultLauncher resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == Activity.RESULT_OK) {



                }
            }
        });



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setBackgroundColor(getResources().getColor(R.color.white));
                btn1.setTextColor(getResources().getColor(R.color.black));
                btn2.setBackgroundColor(getResources().getColor(R.color.black));
                btn2.setTextColor(getResources().getColor(R.color.white));
                btn3.setBackgroundColor(getResources().getColor(R.color.black));
                btn3.setTextColor(getResources().getColor(R.color.white));

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setBackgroundColor(getResources().getColor(R.color.black));
                btn1.setTextColor(getResources().getColor(R.color.white));
                btn2.setBackgroundColor(getResources().getColor(R.color.white));
                btn2.setTextColor(getResources().getColor(R.color.black));
                btn3.setBackgroundColor(getResources().getColor(R.color.black));
                btn3.setTextColor(getResources().getColor(R.color.white));

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setBackgroundColor(getResources().getColor(R.color.black));
                btn2.setBackgroundColor(getResources().getColor(R.color.black));
                btn1.setTextColor(getResources().getColor(R.color.white));
                btn2.setTextColor(getResources().getColor(R.color.white));

                btn3.setBackgroundColor(getResources().getColor(R.color.white));
                btn3.setTextColor(getResources().getColor(R.color.black));
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Ejercicio2.this,"Accediendo a la siguiente plantilla",Toast.LENGTH_SHORT).show();
                //Llamo a la nueva actividad y le paso datos
                Intent intent_ejercicio2 = new Intent(Ejercicio2.this,Ejercicio3.class);
//                startActivity(intent_ejercicio2);
                resultLauncher.launch(intent_ejercicio2);
            }
        });

    }
}
