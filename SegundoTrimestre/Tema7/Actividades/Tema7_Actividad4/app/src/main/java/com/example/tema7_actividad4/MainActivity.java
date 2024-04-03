package com.example.tema7_actividad4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        TextView mostrar = findViewById(R.id.tvMostrar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try(OutputStreamWriter miFichero = new OutputStreamWriter(openFileOutput("fichero.txt",MODE_PRIVATE));) {
                    String texto = et.getText().toString();
                    miFichero.write(texto);
                    et.setText("");
                    Toast.makeText(MainActivity.this, "Se ha guardado", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try(BufferedReader miFichero = new BufferedReader(new InputStreamReader(openFileInput("fichero.txt")));) {
                    String texto = miFichero.readLine();
                    mostrar.setText(texto);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}