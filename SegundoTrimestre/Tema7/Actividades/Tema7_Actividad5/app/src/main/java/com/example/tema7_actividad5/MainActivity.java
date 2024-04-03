package com.example.tema7_actividad5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et = findViewById(R.id.txt);
        Button btnGuardar = findViewById(R.id.btnGuardar);
        Button btnRecuperar = findViewById(R.id.btnRecuperar);
        TextView mostrar=findViewById(R.id.tvMostrar);




        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean sdDisponible = false;
                boolean sdAccesoEscritura = false;

                String estado = Environment.getExternalStorageState();

                if(estado.equals(Environment.MEDIA_MOUNTED)){
                    sdDisponible = true;
                    sdAccesoEscritura = true;
                } else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
                    sdDisponible = true;
                }
                // Escribo en la tarjeta SD
                if(sdDisponible && sdAccesoEscritura){
                    try{
                        File ruta_sd = Environment.getExternalStorageDirectory();

                        File f = new File(ruta_sd.getAbsolutePath(),"actividad5_sd.txt");
                        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(f));
                        String texto=et.getText().toString();
                        out.write(texto);
                        out.close();
                    } catch (Exception e){
                        Log.e("Ficheros","Error al escribir en la tarjeta SD");
                    }
                }
            }
        });

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean sdDisponible = false;
                String estado = Environment.getExternalStorageState();

                if(estado.equals(Environment.MEDIA_MOUNTED)){
                    sdDisponible = true;
                } else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
                    sdDisponible = true;
                }

                if(sdDisponible){
                    try{
                        File ruta_sd = Environment.getExternalStorageDirectory();

                        File f = new File(ruta_sd.getAbsolutePath(),"actividad5_sd.txt");

                        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                        String texto = in.readLine();
                        mostrar.setText(texto);
                        in.close();

                    } catch(Exception e){
                        Log.e("Ficheros","Error al leer de la tarjeta SD");
                    }
                }
            }
        });
    }
}