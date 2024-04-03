package com.example.ejemplosalite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Abrimos la base de datos en modo escritura
        UsuarioBBDD usuarioBBDD = new UsuarioBBDD(this,"DBUsuarios", null,1);
        SQLiteDatabase db = usuarioBBDD.getWritableDatabase();

        if (db!=null){
           // Inseto 5 usuarios
           String usuario;
           for(int i=1; i<5; i++){
               usuario = "Usuario" + i;
               db.execSQL("INSERT INTO Usuarios(codigo,nombre) VALUES " + i + ", '" + usuario + "')");
            }
           // Cerramos la base de datos
           db.close();
        }
    }
}