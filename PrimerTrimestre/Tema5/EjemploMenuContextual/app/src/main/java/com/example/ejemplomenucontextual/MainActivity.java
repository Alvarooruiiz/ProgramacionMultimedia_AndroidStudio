package com.example.ejemplomenucontextual;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView etiqueta = findViewById(R.id.tvEtiqueta);
        registerForContextMenu(etiqueta);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.manu_contextual,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int opcion = item.getItemId();
        if(opcion==R.id.mnOp1){
            final Intent intent = new Intent(MainActivity.this, Clase2.class);
            startActivity(intent);
        }else if(opcion==R.id.mnOp2){

        }
        if(opcion==R.id.mnOp3){
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}