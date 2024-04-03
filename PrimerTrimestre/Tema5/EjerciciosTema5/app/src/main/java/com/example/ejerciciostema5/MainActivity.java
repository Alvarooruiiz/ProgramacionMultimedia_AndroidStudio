package com.example.ejerciciostema5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        actividad2();
//        actividad3();
        actividad4();
    }

    public void actividad2(){
        setContentView(R.layout.actividad2);

        ListView lvSeries =findViewById(R.id.listViewSeries);
        TextView tvSeries = findViewById(R.id.textViewSeries);

        final String[] series = {"Prision Break", "Breaking Bad", "Vikingos", "GOT", "Dark", "Lupin", "Castle", "Friends", "Chernobyl", "Stranger Things"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,series);
        lvSeries.setAdapter(adaptador);

        lvSeries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String serieSeleccionada = series[position];
                tvSeries.setText(serieSeleccionada);
            }
        });
    }

    public void actividad3(){
        setContentView(R.layout.actividad3);

        GridView gvSeries = findViewById(R.id.gvSeries);
        TextView tvSeries = findViewById(R.id.tvSeries);

        final String[] series = {"Prision Break", "Breaking Bad", "Vikingos", "GOT", "Dark", "Lupin", "Castle", "Friends", "Chernobyl", "Stranger Things"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,series);
        gvSeries.setAdapter(adaptador);

        gvSeries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String serieSeleccionada = series[position];
                tvSeries.setText(serieSeleccionada);
            }
        });
    }

    public void actividad4(){
        setContentView(R.layout.actividad4);

        Spinner miSpinner = findViewById(R.id.miSpinner);
        TextView tvSeries = findViewById(R.id.tvSeries);

        final String[] series = {"Prision Break", "Breaking Bad", "Vikingos", "GOT", "Dark", "Lupin", "Castle", "Friends", "Chernobyl", "Stranger Things"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,series);
        miSpinner.setAdapter(adaptador);



        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String serieSeleccionada = series[position];
                tvSeries.setText(serieSeleccionada);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tvSeries.setText("");
            }
        });
    }
}