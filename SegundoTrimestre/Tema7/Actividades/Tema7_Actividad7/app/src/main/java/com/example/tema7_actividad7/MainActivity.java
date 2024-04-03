package com.example.tema7_actividad7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNombre = findViewById(R.id.etNombre);
        EditText etApellidos = findViewById(R.id.etApellidos);
        EditText etCodigo = findViewById(R.id.etCodigo);

        Button btnInsertar = findViewById(R.id.btnInsertar);
        Button btnActualizar = findViewById(R.id.btnActualizar);
        Button btnBorrar = findViewById(R.id.btnBorrar);
        Button btnActBorr = findViewById(R.id.btnACTBORR);
        Button btnConsulta = findViewById(R.id.btnListar);

        TextView tvConsulta = findViewById(R.id.tvConsulta);

        LinearLayout ll2 = findViewById(R.id.ll2);

        UsuariosBBDD usuariosBBDD = new UsuariosBBDD(this,"DBUsuarios",null,1);
        SQLiteDatabase db= usuariosBBDD.getWritableDatabase();

        if(db!=null){
            btnInsertar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String nombre = etNombre.getText().toString();
                    String apellidos = etApellidos.getText().toString();

                    ContentValues registro = new ContentValues();
                    registro.put("nombre",nombre);
                    registro.put("apellidos",apellidos);
                    db.insert("Usuarios",null,registro);

                    Toast.makeText(MainActivity.this, "Se ha insertado un usuario", Toast.LENGTH_SHORT).show();
                }
            });

            btnActBorr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(ll2.getVisibility()==View.VISIBLE){
                        ll2.setVisibility(View.GONE);
                    }else{
                        ll2.setVisibility(View.VISIBLE);
                    }
                }
            });

            btnActualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String codigo = etCodigo.getText().toString();
                    String nombre = etNombre.getText().toString();
                    String apellidos = etApellidos.getText().toString();

                    String args[] = new String[]{codigo};
                    db.execSQL("UPDATE Usuarios SET nombre='" + nombre + "' WHERE codigo=?", args);
                    db.execSQL("UPDATE Usuarios SET apellidos='" + apellidos + "' WHERE codigo=?", args);

                    Toast.makeText(MainActivity.this, "Se ha actualizado el usuario con codigo: " + codigo, Toast.LENGTH_SHORT).show();
                }
            });

            btnBorrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String cod = etCodigo.getText().toString();

                    db.execSQL("DELETE FROM Usuarios WHERE codigo='" + cod + "'");

                    Toast.makeText(MainActivity.this, "Se ha eliminado el usuario con codigo: " + cod, Toast.LENGTH_SHORT).show();
                }
            });

            btnConsulta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tvConsulta.setText("");
                    Cursor c = db.rawQuery(" SELECT codigo,nombre,apellidos FROM Usuarios", null);
                    if(c.moveToFirst()){
                        do{
                            String codigo = c.getString(0);
                            String nombre = c.getString(1);
                            String apellidos = c.getString(2);

                            String usuario = codigo + " " + nombre + " " + apellidos;
                            tvConsulta.append(usuario + "\n");
                        }while(c.moveToNext());

                    }
                }
            });
        }

    }
}