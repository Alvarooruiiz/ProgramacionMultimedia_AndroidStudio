package com.example.tema7_actividad8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNombre = findViewById(R.id.etNombre);
        EditText etApellidos = findViewById(R.id.etApellidos);

        Button btnInsertar = findViewById(R.id.btnInsertar);
        Button btnActualizar = findViewById(R.id.btnActualizar);
        Button btnBorrar = findViewById(R.id.btnBorrar);
        Button btnConsulta = findViewById(R.id.btnConsulta);

        ListView lvLista = findViewById(R.id.lvLista);

        ArrayList<String> dataList = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);

        UsuariosBBDD usuariosBBDD = new UsuariosBBDD(this,"DBUsuarios",null,1);
        SQLiteDatabase db= usuariosBBDD.getWritableDatabase();

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

        btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Limpiar el contenido del ListView
                dataList.clear();
                adapter.notifyDataSetChanged(); // Notificar al adaptador sobre el cambio en los datos
                lvLista.setAdapter(null); // Establecer el adaptador en null para eliminar cualquier adaptador anterior

                // Realizar la consulta y poblar el ListView nuevamente
                Cursor c = db.rawQuery("SELECT codigo, nombre, apellidos FROM Usuarios", null);
                if(c.moveToFirst()) {
                    do {
                        String codigo = c.getString(0);
                        String nombre = c.getString(1);
                        String apellidos = c.getString(2);

                        String usuario = codigo + " " + nombre + " " + apellidos;
                        dataList.add(usuario);
                    } while (c.moveToNext());

                    // Establecer el adaptador nuevamente con los nuevos datos
                    lvLista.setAdapter(adapter);
                }
            }
        });

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Guardar la posición del elemento seleccionado
                pos = position;

                // Obtener el usuario seleccionado
                String usuarioSeleccionado = dataList.get(pos);

                // Dividir el usuario seleccionado para obtener el nombre y apellidos
                String[] partes = usuarioSeleccionado.split(" ");
                String nombre = partes[1];
                String apellidos = partes[2];

                // Actualizar los EditText con los datos del usuario seleccionado
                etNombre.setText(nombre);
                etApellidos.setText(apellidos);
            }
        });


        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pos != -1) {
                    // Obtener el usuario seleccionado
                    String usuarioSeleccionado = dataList.get(pos);
                    // Dividir el usuario seleccionado para obtener el nombre y apellidos
                    String[] partes = usuarioSeleccionado.split(" ");
                    String nombre = partes[1];
                    // Eliminar el usuario de la base de datos
                    db.delete("Usuarios", "nombre=?", new String[]{nombre});
                    // Eliminar el usuario de la lista
                    dataList.remove(pos);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Usuario eliminado", Toast.LENGTH_SHORT).show();
                    pos = -1; // Restablecer la posición
                } else {
                    Toast.makeText(MainActivity.this, "Seleccione un usuario para eliminar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pos != -1) {
                    // Obtener el usuario seleccionado
                    String usuarioSeleccionado = dataList.get(pos);
                    // Dividir el usuario seleccionado para obtener el nombre y apellidos
                    String[] partes = usuarioSeleccionado.split(" ");
                    String nombre = partes[1];
                    // Obtener los nuevos valores de los EditText
                    String nuevoNombre = etNombre.getText().toString();
                    String nuevosApellidos = etApellidos.getText().toString();
                    // Actualizar los datos en la base de datos
                    ContentValues valores = new ContentValues();
                    valores.put("nombre", nuevoNombre);
                    valores.put("apellidos", nuevosApellidos);
                    db.update("Usuarios", valores, "nombre=?", new String[]{nombre});
                    // Actualizar la lista
                    dataList.set(pos, partes[0] + " " + nuevoNombre + " " + nuevosApellidos);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Usuario actualizado", Toast.LENGTH_SHORT).show();
                    pos = -1; // Restablecer la posición
                } else {
                    Toast.makeText(MainActivity.this, "Seleccione un usuario para actualizar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}