package com.example.actividades7tema5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    private String[] animalNames = {"Buho", "Jirafa", "Tigre", "Cachorro", "Lobo", "Tortuga", "Cerdo", "Potro", "Tucán"};
    private int[] animalImages = {R.drawable.buho, R.drawable.jirafas, R.drawable.tigre, R.drawable.cachorros, R.drawable.lobo, R.drawable.tortuga, R.drawable.cerdo, R.drawable.potro, R.drawable.tucan};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this, animalNames, animalImages));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, animalNames[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}