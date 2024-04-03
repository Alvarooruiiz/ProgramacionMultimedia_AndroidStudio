package com.example.practicaevaluaciontema5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int MnOp1 =1;
    private static final int MnOp2 =2;
    private static final int MnOp2_1 =3;
    private static final int MnOp2_2 =4;
    private static final int MnOp2_3 =5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton btnLlamar = findViewById(R.id.llamar);
        ImageButton btnCorreo = findViewById(R.id.correo);
        ImageButton btnWeb = findViewById(R.id.web);

        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamarTelefono();
            }
        });
        btnCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mandarCorreo();
            }
        });
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPagina();
            }
        });

        Button btnValorar = findViewById(R.id.btnValorar);
        btnValorar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Valoracion.class);
                startActivity(intent);
            }
        });

        ImageView logoImageView = findViewById(R.id.logo);
        registerForContextMenu(logoImageView);

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.logo_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        ImageView logoImageView = findViewById(R.id.logo);
        int id = item.getItemId();

        if(id == R.id.logo1){
            logoImageView.setImageResource(R.drawable.logo);
        }else if(id == R.id.logo2){
            logoImageView.setImageResource(R.drawable.logo2);
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, MnOp1, Menu.NONE,"¿Qué ver?");
        SubMenu subMenu2 = menu.addSubMenu(Menu.NONE, MnOp2, Menu.NONE, "Temas");
        subMenu2.add(Menu.NONE, MnOp2_1, Menu.NONE, "Normal");
        subMenu2.add(Menu.NONE, MnOp2_2, Menu.NONE, "Oscuro");
        subMenu2.add(Menu.NONE, MnOp2_3, Menu.NONE, "Azul");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ConstraintLayout constraintLayout = findViewById(R.id.miLoyaut);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Button btn = findViewById(R.id.btnValorar);
        TextView tx = findViewById(R.id.titulo);
        int colorFondo;
        int colorBoton;

        switch (item.getItemId()){
            case MnOp1:
                Intent intent1 = new Intent(MainActivity.this, QueVer.class);
                startActivity(intent1);
                break;

            case MnOp2_1:
                colorFondo = Color.parseColor("#f6e7d3");
                constraintLayout.setBackgroundColor(colorFondo);

                colorBoton = Color.parseColor("#9f0a28");
                btn.setBackgroundColor(colorBoton);

                tx.setTextColor(colorBoton);

                toolbar.setBackgroundColor(colorBoton);
                toolbar.setTitleTextColor(Color.WHITE);
                break;

            case MnOp2_2:
                colorFondo = Color.parseColor("#5d544d");
                constraintLayout.setBackgroundColor(colorFondo);

                colorBoton = Color.parseColor("#291d21");
                btn.setBackgroundColor(colorBoton);

                tx.setTextColor(Color.WHITE);

                toolbar.setBackgroundColor(colorBoton);
                toolbar.setTitleTextColor(Color.WHITE);
                break;
            case MnOp2_3:
                colorFondo = Color.parseColor("#f2f2f2");
                constraintLayout.setBackgroundColor(colorFondo);

                colorBoton = Color.parseColor("#348e91");
                btn.setBackgroundColor(colorBoton);

                tx.setTextColor(Color.BLACK);

                toolbar.setBackgroundColor(colorBoton);
                toolbar.setTitleTextColor(Color.WHITE);
                break;
        }
        return true;
    }

    public void llamarTelefono(){
        Intent intent = new
                Intent(Intent.ACTION_DIAL, Uri.parse("tel:666666666"));
        startActivity(intent);
    }

    public void mandarCorreo(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,"Asunto");
        intent.putExtra(Intent.EXTRA_TEXT,"Introduzca su pregunta");
        intent.putExtra(Intent.EXTRA_EMAIL, new
                String[]{"servicio@alvaroFlix.com"});
        startActivity(intent);
    }

    public void abrirPagina(){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.AlvaroFlix.es/"));
        startActivity(intent);
    }
}