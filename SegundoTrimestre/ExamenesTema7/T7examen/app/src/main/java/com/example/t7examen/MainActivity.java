package com.example.t7examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.t7examen.adaptador.Adaptador;
import com.example.t7examen.adaptador.Datos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int MnOp1 = 1;
    String seleccionado;
    SQLiteDatabase sqLiteDatabase;
    ListView listTendencias;
    ListView listMiLista;
    LinearLayout llInvisibleTend;
    LinearLayout llInvisibleList;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, MnOp1, Menu.NONE, "Configuracion");
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(MainActivity.this, OpcionesActivity.class));
        return true;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAñadir=findViewById(R.id.btnAñadir);
        Button btnCancelar1=findViewById(R.id.btnCancelar1);
        Button btnCancelar2=findViewById(R.id.btnCancelar2);
        Button btnQuitar=findViewById(R.id.btnQuitar);
        llInvisibleTend=(LinearLayout) findViewById(R.id.llInvisibleTend);
        llInvisibleList=(LinearLayout) findViewById(R.id.llInvisibleList);
        listTendencias=findViewById(R.id.listTendencias);
        listMiLista=findViewById(R.id.listMiLista);


        insercionBaseDatos();
        rellenarTendencias();
        rellenarMiLista();


        listTendencias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adaptador, View view, int position, long id) {
                seleccionado = ((Datos) adaptador.getItemAtPosition(position)).getNombre();
                llInvisibleTend.setVisibility(View.VISIBLE);
                llInvisibleList.setVisibility(View.GONE);
            }
        });


        listMiLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adaptador, View view, int position, long id) {
                seleccionado = ((Datos) adaptador.getItemAtPosition(position)).getNombre();
                llInvisibleList.setVisibility(View.VISIBLE);
                llInvisibleTend.setVisibility(View.GONE);
            }
        });


        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase.execSQL("UPDATE peliculas SET lista=1 WHERE nombre='"+seleccionado+"'");
                rellenarMiLista();
                llInvisibleTend.setVisibility(View.INVISIBLE);
                llInvisibleList.setVisibility(View.GONE);
            }
        });


        btnCancelar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llInvisibleTend.setVisibility(View.INVISIBLE);
                llInvisibleList.setVisibility(View.GONE);
            }
        });



        btnCancelar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llInvisibleTend.setVisibility(View.GONE);
                llInvisibleList.setVisibility(View.INVISIBLE);
            }
        });


        btnQuitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase.execSQL("UPDATE peliculas SET lista=0 WHERE nombre='"+seleccionado+"'");
                rellenarMiLista();
                llInvisibleList.setVisibility(View.INVISIBLE);
                llInvisibleTend.setVisibility(View.GONE);
            }
        });
    }



    public void insercionBaseDatos() {
        BD BD = new BD(this,"BDpeliculas",null,1);
        sqLiteDatabase = BD.getWritableDatabase();
        sqLiteDatabase.execSQL("delete from peliculas;");
        sqLiteDatabase.execSQL("INSERT INTO peliculas(nombre,foto,lista) VALUES ('ALQUIMIA',"+R.drawable.alquimia+",'0')");
        sqLiteDatabase.execSQL("INSERT INTO peliculas(nombre,foto,lista) VALUES ('BREAKING BAD',"+R.drawable.breaking+",'0')");
        sqLiteDatabase.execSQL("INSERT INTO peliculas(nombre,foto,lista) VALUES ('BROADCHURCH',"+R.drawable.broadchurch+",'0')");
        sqLiteDatabase.execSQL("INSERT INTO peliculas(nombre,foto,lista) VALUES ('ERASED',"+R.drawable.erased+",'0')");
        sqLiteDatabase.execSQL("INSERT INTO peliculas(nombre,foto,lista) VALUES ('HILL',"+R.drawable.hill+",'0')");
        sqLiteDatabase.execSQL("INSERT INTO peliculas(nombre,foto,lista) VALUES ('HOWL',"+R.drawable.howl+",'0')");
        sqLiteDatabase.execSQL("INSERT INTO peliculas(nombre,foto,lista) VALUES ('LUCIFER',"+R.drawable.lucifer+",'0')");
        sqLiteDatabase.execSQL("INSERT INTO peliculas(nombre,foto,lista) VALUES ('STRANGER THINGS',"+R.drawable.stranger+",'0')");
        sqLiteDatabase.execSQL("INSERT INTO peliculas(nombre,foto,lista) VALUES ('SUPERNATURAL',"+R.drawable.supernatural+",'0')");
        sqLiteDatabase.execSQL("INSERT INTO peliculas(nombre,foto,lista) VALUES ('ATTACK ON TITAN',"+R.drawable.titanes+",'0')");
    }



    public void rellenarTendencias() {
        ArrayList<Datos> datos = new ArrayList<Datos>();
        Adaptador adaptador = new Adaptador(this,datos);
        Cursor miCursor = sqLiteDatabase.rawQuery("SELECT nombre,foto FROM peliculas;",null);
        if (miCursor.moveToFirst()){
            do{
                String nombre = miCursor.getString(0);
                int foto = miCursor.getInt(1);
                datos.add(new Datos(nombre,foto));
            } while (miCursor.moveToNext());
            miCursor.close();
        }
        listTendencias.setAdapter(adaptador);
    }



    public void rellenarMiLista() {
        ArrayList<Datos> datos = new ArrayList<Datos>();
        Adaptador adaptador = new Adaptador(this,datos);
        Cursor miCursor = sqLiteDatabase.rawQuery("SELECT nombre,foto FROM peliculas WHERE lista=1;",null);
        if (miCursor.moveToFirst()){
            do{
                String nombre = miCursor.getString(0);
                int foto = miCursor.getInt(1);
                datos.add(new Datos(nombre,foto));
            } while (miCursor.moveToNext());
            miCursor.close();
        }
        listMiLista.setAdapter(adaptador);
    }
}