package com.example.ejemplomemoriasd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
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

        // PARA REALIZARLO SE HAN INTRODUCIDO EN EL MANIFEST DOS LINEAS
        // ESTE PROGRAMA FUNCIONA SOLO HASTA LA API 29 (SIN INCLUI)
        //PARA QUE FUNCIONE EN TODAS LAS APIS, EJECUTAR LAS LINEAS COMENTADAS

        boolean sdDisponible = false;
        boolean sdAccesoEscritura = false;

        // Comprobamos el estado de la memoria SD
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
                // Obtengo la ruta del directorio raiz
                File ruta_sd = Environment.getExternalStorageDirectory();
//                File ruta_sd = getExternalFilesDir(null);

                File f = new File(ruta_sd.getAbsolutePath(),"prueba_sd.txt");
                OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(f));
                out.write("Texto de prueba");
                out.close();

            } catch (Exception e){
                Log.e("Ficheros","Error al escribir en la tarjeta SD");
            }
        }

        // Leo los datos
        if(sdDisponible){
            try{
                // Obtengo la ruta del directorio raiz
                File ruta_sd = Environment.getExternalStorageDirectory();
//                File ruta_sd = getExternalFilesDir(null);

                File f = new File(ruta_sd.getAbsolutePath(),"prueba_sd.txt");

                BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                String texto = in.readLine();
                Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
                in.close();

            } catch(Exception e){
                Log.e("Ficheros","Error al leer de la tarjeta SD");
            }
        }
    }
}