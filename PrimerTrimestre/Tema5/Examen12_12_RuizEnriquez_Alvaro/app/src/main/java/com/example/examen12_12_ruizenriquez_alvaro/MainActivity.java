package com.example.examen12_12_ruizenriquez_alvaro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int MnOp1 =1;
    private static final int MnOp1_1 =2;
    private static final int MnOp1_2 =3;
    private static final int MnOp2 =4;
    private static final int MnOp2_1 =5;
    private static final int MnOp2_2 =6;
    private static final int MnOp2_3 =7;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        SubMenu subMenu1 = menu.addSubMenu(Menu.NONE, MnOp1, Menu.NONE, "Intents");
        subMenu1.add(Menu.NONE, MnOp1_1, Menu.NONE, "Intent explicito");
        subMenu1.add(Menu.NONE, MnOp1_2, Menu.NONE, "Intent implicito");

        SubMenu subMenu2 = menu.addSubMenu(Menu.NONE, MnOp2, Menu.NONE, "Listados");
        subMenu2.add(Menu.NONE, MnOp2_1, Menu.NONE, "ListView");
        subMenu2.add(Menu.NONE, MnOp2_2, Menu.NONE, "GridView");
        subMenu2.add(Menu.NONE, MnOp2_3, Menu.NONE, "Spinner");
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Handler handler = new Handler();
        final TextView etiqueta = findViewById(R.id.etiquetaPrincipal);
        Intent intentExplicito = new Intent(MainActivity.this, IntentExplicito.class);


        final ListView listaList = findViewById(R.id.lv1);
        final GridView listaGrid = findViewById(R.id.miGrid);
        final Spinner spinner = findViewById(R.id.miSpinner);
        String datos[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};


        switch (item.getItemId()){
            case MnOp1_1:
                etiqueta.setText("Ejecutando Intent Explicito");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        startActivity(intentExplicito);
                    }
                }, 3000);
                break;

            case MnOp1_2:
                etiqueta.setText("Enviando correo");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mandarCorreo();
                    }
                }, 3000);
                break;

            case MnOp2_1:
                listaGrid.setVisibility(View.INVISIBLE);
                spinner.setVisibility(View.INVISIBLE);
                etiqueta.setText("Creando Lista con ListView");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        listaList.setVisibility(View.VISIBLE);
                        ArrayAdapter<String>adaptador= new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,datos);
                        listaList.setAdapter(adaptador);
                    }
                }, 3000);

                break;
            case MnOp2_2:
                listaList.setVisibility(View.INVISIBLE);
                spinner.setVisibility(View.INVISIBLE);
                etiqueta.setText("Creando Lista con GridView");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        listaGrid.setVisibility(View.VISIBLE);

                        ArrayAdapter<String>adaptador2= new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,datos);
                        listaGrid.setAdapter(adaptador2);

                    }
                }, 3000);


                break;
            case MnOp2_3:
                listaList.setVisibility(View.INVISIBLE);
                listaGrid.setVisibility(View.INVISIBLE);
                etiqueta.setText("Creando Lista con Spinner");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        spinner.setVisibility(View.VISIBLE);

                        ArrayAdapter<String>adaptador3= new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,datos);
                        spinner.setAdapter(adaptador3);

                    }
                }, 3000);

                break;
        }
        return true;
    }

//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        MenuInflater inflater = getMenuInflater();
//        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
//        menu.setHeaderTitle(listaList.getAdapter().getItem(info.position).toString());
//        switch (info.position){
//            case 0:
//                inflater.inflate(R.menu.menu,menu);
//            case 1:
//                inflater.inflate(R.menu.menu,menu);
//        }
//    }
//
//    @Override
//    public boolean onContextItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.CmCrearCita:
//                break;
//
//            case R.id.CmVerCita:
//                break;
//        }
//        return super.onContextItemSelected(item);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void mandarCorreo(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,"examen t5");
        intent.putExtra(Intent.EXTRA_TEXT,"Alvaro. Intent implícito OK");
        intent.putExtra(Intent.EXTRA_EMAIL, new
                String[]{"rbaebar562@g.educaand.es"});
        startActivity(intent);
    }
}