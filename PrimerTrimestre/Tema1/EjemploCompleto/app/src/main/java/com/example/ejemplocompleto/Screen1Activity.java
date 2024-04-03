package com.example.ejemplocompleto;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Screen1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen1);

        TextView textViewScreen1 = findViewById(R.id.textViewScreen1);
        Spinner spinnerScreen1 = findViewById(R.id.spinnerScreen1);
        Button btnContextualMenuScreen1 = findViewById(R.id.btnContextualMenuScreen1);

        // Configuración del Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.spinner_items,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerScreen1.setAdapter(adapter);

        // Configuración del menú contextual
        registerForContextMenu(btnContextualMenuScreen1);

        btnContextualMenuScreen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContextMenu(v);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu_screen1, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.context_menu_item_1) {
            // Acciones para el elemento 1 del menú contextual
            Toast.makeText(this, "Seleccionaste Elemento 1", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.context_menu_item_2) {
            // Acciones para el elemento 2 del menú contextual
            Toast.makeText(this, "Seleccionaste Elemento 2", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }
}