package com.example.tema4_actividad4;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tema4_actividad4.R;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private CheckBox checkBox;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener referencias a los elementos del layout
        textView = findViewById(R.id.textView);
        checkBox = findViewById(R.id.checkBox);
        listView = findViewById(R.id.listView);

        // Configurar el ListView con un adaptador personalizado
        CustomAdapter customAdapter = new CustomAdapter(this);
        listView.setAdapter(customAdapter);

        // Registrar el ListView para el menú contextual
        registerForContextMenu(listView);
    }

    // Métodos para manejar intents explícitos e implícitos
    public void explicitIntentExample(View view) {
        Intent explicitIntent = new Intent(this, SecondActivity.class);
        startActivity(explicitIntent);
    }

    public void implicitIntentExample(View view) {
        Intent implicitIntent = new Intent(Intent.ACTION_VIEW);
        implicitIntent.setData(android.net.Uri.parse("http://www.example.com"));
        startActivity(implicitIntent);
    }

    // Crear menús
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menu_option1:
//                // Manejar la opción del menú
//                return true;
//            case R.id.menu_option2:
//                // Manejar la opción del menú
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    // Crear menús contextuales
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

//    @Override
//    public boolean onContextItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.context_option1:
//                // Manejar la opción del menú contextual
//                return true;
//            case R.id.context_option2:
//                // Manejar la opción del menú contextual
//                return true;
//            default:
//                return super.onContextItemSelected(item);
//        }
//    }
}