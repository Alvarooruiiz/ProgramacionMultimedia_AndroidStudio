package com.example.exament7_13_02_ruizenriquezalvaro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        private Intent configuracion;
    private SQLiteDatabase sqLiteDatabase;
    private ListView lvTendencias;
    private LinearLayout llInvisible;
    private Button btnAnadir;
    private Button btnCancelar;

    private ListView lvMiLista;
    private LinearLayout llInvisible2;
    private Button btnBorrar;
    private Button btnCancelar2;
    private String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        llInvisible = findViewById(R.id.layoutInvisible);
        btnAnadir = findViewById(R.id.btnAnadir);
        btnAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase.execSQL("UPDATE Cine SET lista=1 WHERE nombre = '"+nombre+"'");
                rellenarListaMiLista();
            }
        });

        btnCancelar = findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llInvisible.setVisibility(View.GONE);
            }
        });

        llInvisible2 = findViewById(R.id.layoutInvisible2);
        btnBorrar = findViewById(R.id.btnBorrar);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase.execSQL("UPDATE Cine SET lista=0 WHERE nombre='"+nombre+"'");
                rellenarListaMiLista();
            }
        });


        btnCancelar2 = findViewById(R.id.btnCancelar2);
        btnCancelar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llInvisible2.setVisibility(View.GONE);
            }
        });

        lvTendencias = findViewById(R.id.lvTendencias);
        lvTendencias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nombre = ((Cine) parent.getItemAtPosition(position)).getNombre();
                llInvisible.setVisibility(View.VISIBLE);
                llInvisible2.setVisibility(View.GONE);
            }
        });

        lvMiLista = findViewById(R.id.lvMiLista);
        lvMiLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nombre = ((Cine) parent.getItemAtPosition(position)).getNombre();
                llInvisible2.setVisibility(View.VISIBLE);
                llInvisible.setVisibility(View.GONE);
            }
        });



        configuracion = new Intent(MainActivity.this, configPreferences.class);

        insercionDatos();
        rellenarListaTendencias();
        rellenarListaMiLista();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.config,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.MnOpConfig){
            startActivity(configuracion);
        }
        return super.onOptionsItemSelected(item);
    }

    public void rellenarListaTendencias(){
        ArrayList<Cine> listaTendencias = new ArrayList<>();
        Adaptador adaptador = new Adaptador(this,listaTendencias);
        Cursor c = sqLiteDatabase.rawQuery("SELECT nombre,foto FROM cine;",null);
        if(c.moveToFirst()){
            do{
                String nombre = c.getString(0);
                int foto = c.getInt(1);
                listaTendencias.add(new Cine(foto,nombre));
            }while (c.moveToNext());
            c.close();
        }
        lvTendencias.setAdapter(adaptador);
    }

    public void rellenarListaMiLista(){
        ArrayList<Cine> listaMiLista = new ArrayList<>();
        Adaptador adaptador = new Adaptador(this,listaMiLista);
        Cursor c = sqLiteDatabase.rawQuery("SELECT nombre,foto FROM cine WHERE lista=1;",null);
        if(c.moveToFirst()){
            do{
                String nombre = c.getString(0);
                int foto = c.getInt(1);
                listaMiLista.add(new Cine(foto,nombre));
            }while (c.moveToNext());
            c.close();
        }
        lvMiLista.setAdapter(adaptador);
    }


    public void insercionDatos() {
          CineBBDD bd = new CineBBDD(this,"BDcine",null,1);
        sqLiteDatabase = bd.getWritableDatabase();
        sqLiteDatabase.execSQL("delete from Cine;");
        sqLiteDatabase.execSQL("INSERT INTO Cine(nombre,foto,lista) VALUES ('ALQUIMIA',"+R.drawable.alquimia+",'0')");
        sqLiteDatabase.execSQL("INSERT INTO Cine(nombre,foto,lista) VALUES ('BREAKING BAD',"+R.drawable.breaking+",'0')");
        sqLiteDatabase.execSQL("INSERT INTO Cine(nombre,foto,lista) VALUES ('BROADCHURCH',"+R.drawable.broadchurch+",'0')");
        sqLiteDatabase.execSQL("INSERT INTO Cine(nombre,foto,lista) VALUES ('ERASED',"+R.drawable.erased+",'0')");
        sqLiteDatabase.execSQL("INSERT INTO Cine(nombre,foto,lista) VALUES ('HILL',"+R.drawable.hill+",'1')");
        sqLiteDatabase.execSQL("INSERT INTO Cine(nombre,foto,lista) VALUES ('HOWL',"+R.drawable.howl+",'1')");
        sqLiteDatabase.execSQL("INSERT INTO Cine(nombre,foto,lista) VALUES ('LUCIFER',"+R.drawable.lucifer+",'0')");
        sqLiteDatabase.execSQL("INSERT INTO Cine(nombre,foto,lista) VALUES ('STRANGER THINGS',"+R.drawable.stranger+",'0')");
        sqLiteDatabase.execSQL("INSERT INTO Cine(nombre,foto,lista) VALUES ('SUPERNATURAL',"+R.drawable.supernatural+",'0')");
        sqLiteDatabase.execSQL("INSERT INTO Cine(nombre,foto,lista) VALUES ('ATTACK ON TITAN',"+R.drawable.titanes+",'0')");
    }
}