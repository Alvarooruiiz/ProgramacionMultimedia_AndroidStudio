package com.example.ejercicio6;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Spinner miSpinner;
    private ImageView imagen;
    private LinearLayout botones;
    private Button btnAnterior;
    private Button btnSiguiente;
    private final int[] imagenesIds = {
            R.drawable.batman,
            R.drawable.capi,
            R.drawable.deadpool,
            R.drawable.furia,
            R.drawable.hulk,
            R.drawable.ironman,
            R.drawable.lobezno,
            R.drawable.spiderman,
            R.drawable.thor,
            R.drawable.wonderwoman
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miSpinner = findViewById(R.id.miSpinner);
        imagen = findViewById(R.id.imagen);
        botones = findViewById(R.id.botones);
        btnAnterior = findViewById(R.id.btnAnterior);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        // Crear y configurar el adaptador personalizado para el Spinner
        ImageSpinnerAdapter adapter = new ImageSpinnerAdapter();
        miSpinner.setAdapter(adapter);

        // Manejar la selección del Spinner
        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imagen.setImageResource(imagenesIds[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Manejar el clic en el botón Guardar
        Button btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarReferencia();
            }
        });

        // Manejar el clic en el botón Borrar
        Button btnBorrar = findViewById(R.id.btnBorrar);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                borrarReferencias();
            }
        });

        // Manejar el clic en el botón Cargar
        Button btnCargar = findViewById(R.id.btnCargar);
        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarImagenes();
            }
        });
    }

    // Método para guardar la referencia de la imagen seleccionada en la memoria SD
    private void guardarReferencia() {
        if (miSpinner.getCount() > 0 && miSpinner.getSelectedItem() != null) {
            String imagenSeleccionada = miSpinner.getSelectedItem().toString();
            String referencia = imagenSeleccionada + ",";
            try {
                File ruta_sd = Environment.getExternalStorageDirectory();
                File file = new File(ruta_sd.getAbsolutePath(), "referencias.txt");
                FileOutputStream outputStream = new FileOutputStream(file, true);
                outputStream.write(referencia.getBytes());
                outputStream.close();
                Toast.makeText(MainActivity.this, "Referencia guardada", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(MainActivity.this, "No hay ninguna imagen seleccionada en el Spinner", Toast.LENGTH_SHORT).show();
        }
    }




    // Método para borrar todas las referencias guardadas en el fichero de texto de la memoria SD
    private void borrarReferencias() {
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File file = new File(ruta_sd.getAbsolutePath(), "referencias.txt");
            if (file.delete()) {
                Toast.makeText(MainActivity.this, "Referencias borradas", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Error al borrar las referencias", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para cargar las imágenes del fichero de texto en la memoria SD
    private void cargarImagenes() {
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File file = new File(ruta_sd.getAbsolutePath(), "referencias.txt");
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line = bufferedReader.readLine();
                if (line != null && !line.isEmpty()) {
                    String[] referencias = line.split(",");
                    if (referencias.length > 0) {
                        imagen.setImageResource(obtenerIdImagen(referencias[0]));
                    }
                }
                bufferedReader.close();
                botones.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(MainActivity.this, "No hay referencias guardadas", Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener el ID de la imagen a partir de su nombre
    private int obtenerIdImagen(String nombreImagen) {
        int idImagen = 0;
        for (int i = 0; i < imagenesIds.length; i++) {
            if (nombreImagen.equals(getResources().getResourceEntryName(imagenesIds[i]))) {
                idImagen = imagenesIds[i];
                break;
            }
        }
        return idImagen;
    }

    // Adaptador personalizado para el Spinner
    private class ImageSpinnerAdapter extends ArrayAdapter<String> {

        ImageSpinnerAdapter() {
            super(MainActivity.this, R.layout.item_spinner_image);
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            return getView(position, convertView, parent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if (row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.item_spinner_image, parent, false);
            }

            ImageView imageView = row.findViewById(R.id.imageView);
            imageView.setImageResource(imagenesIds[position]);

            return row;
        }

        @Override
        public int getCount() {
            return imagenesIds.length;
        }
    }
}
