package com.example.actividad9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextLanzamiento;
    private Button btnMostrar, btnEliminar, btnAgregar;
    private GridView gridView;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextLanzamiento = findViewById(R.id.editTextLanzamiento);
        btnMostrar = findViewById(R.id.btnMostrar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnAgregar = findViewById(R.id.btnAgregar);
        gridView = findViewById(R.id.gridView);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDatos();
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarRegistro();
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarRegistro();
            }
        });

        // Configuración del GridView
        String[] from = new String[]{"nombre", "lanzamiento"};
        int[] to = new int[]{android.R.id.text1, android.R.id.text2};
        adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, null, from, to, 0);
        gridView.setAdapter(adapter);
    }

    private void mostrarDatos() {
        Uri uri = MiContentProvider.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor != null) {
            adapter.swapCursor(cursor);
        }
    }

    private void agregarRegistro() {
        String nombre = editTextNombre.getText().toString();
        String lanzamiento = editTextLanzamiento.getText().toString();

        if (nombre.isEmpty() || lanzamiento.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("lanzamiento", lanzamiento);

        Uri uri = getContentResolver().insert(MiContentProvider.CONTENT_URI, values);
        if (uri != null) {
            Toast.makeText(this, "Registro agregado con éxito", Toast.LENGTH_SHORT).show();
            editTextNombre.setText("");
            editTextLanzamiento.setText("");
        } else {
            Toast.makeText(this, "Error al agregar el registro", Toast.LENGTH_SHORT).show();
        }
    }

    private void eliminarRegistro() {
        int selectedItemPosition = gridView.getSelectedItemPosition();
        if (selectedItemPosition == -1) {
            Toast.makeText(this, "Por favor, seleccione un registro para eliminar", Toast.LENGTH_SHORT).show();
            return;
        }

        Cursor cursor = (Cursor) adapter.getItem(selectedItemPosition);
        int id = cursor.getInt(cursor.getColumnIndex("_id"));
        Uri uri = Uri.parse(MiContentProvider.CONTENT_URI + "/" + id);

        int rowsDeleted = getContentResolver().delete(uri, null, null);
        if (rowsDeleted > 0) {
            Toast.makeText(this, "Registro eliminado con éxito", Toast.LENGTH_SHORT).show();
            mostrarDatos();
        } else {
            Toast.makeText(this, "Error al eliminar el registro", Toast.LENGTH_SHORT).show();
        }
    }


}