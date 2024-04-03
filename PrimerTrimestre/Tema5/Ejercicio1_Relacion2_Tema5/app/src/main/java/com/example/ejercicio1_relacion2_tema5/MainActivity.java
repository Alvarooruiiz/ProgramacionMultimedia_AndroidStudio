package com.example.ejercicio1_relacion2_tema5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MnOp1=1;
    private static final int MnOp2=2;
    private static final int MnOp3=3;
    private static final int MnOp4=4;
    private static final int MnOp5=5;
    private static final int MnOp6=6;
    private static final int MnOp7=7;
//    private static final int MnOp1_1=3;
//    private static final int MnOp1_2=4;
//    private static final int MnOp1_3=5;
//    private static final int MnOp1_4=6;
//    private static final int MnOp1_5=7;
//    private static final int MnOp1_6=8;
//    private static final int MnOp1_7=9;
//    private static final int MnOp2_1=10;
private static final int MnOp2_2=11;
private static final int MnOp2_3=12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        SubMenu smnu1 = menu.addSubMenu(Menu.NONE,MnOp1,Menu.NONE,"DIAS DE LA SEMANA");
//        SubMenu smnu2 = menu.addSubMenu(Menu.NONE,MnOp2,Menu.NONE,"MESES DEL AÑO");
//        smnu1.add(Menu.NONE,MnOp1_1,Menu.NONE,"LUNES");
//        smnu1.add(Menu.NONE,MnOp1_2,Menu.NONE,"MARTES");
//        smnu1.add(Menu.NONE,MnOp1_3,Menu.NONE,"MIERCOLES");
//        smnu1.add(Menu.NONE,MnOp1_4,Menu.NONE,"JUEVES");
//        smnu1.add(Menu.NONE,MnOp1_5,Menu.NONE,"VIERNES");
//        smnu1.add(Menu.NONE,MnOp1_6,Menu.NONE,"SABADO");
//        smnu1.add(Menu.NONE,MnOp1_7,Menu.NONE,"DOMINGO");
//        smnu2.add(Menu.NONE,MnOp2_1,Menu.NONE,"ENERO");
//        smnu2.add(Menu.NONE,MnOp2_2,Menu.NONE,"FEBRERO");
//        smnu2.add(Menu.NONE,MnOp2_3,Menu.NONE,"MARZO");

        menu.add(Menu.NONE,MnOp1,menu.NONE,"LUNES");
        menu.add(Menu.NONE,MnOp2,menu.NONE,"MARTES");
        menu.add(Menu.NONE,MnOp3,menu.NONE,"MIERCOLES");
        menu.add(Menu.NONE,MnOp4,menu.NONE,"JUEVES");
        menu.add(Menu.NONE,MnOp5,menu.NONE,"VIERNES");
        menu.add(Menu.NONE,MnOp6,menu.NONE,"SABADO");
        menu.add(Menu.NONE,MnOp7,menu.NONE,"DOMINGO");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TextView tv = findViewById(R.id.tv);
        switch (item.getItemId()){
            case MnOp1:
                tv.setText("PULSADO " + item.getTitle());
                break;
            case MnOp2:
                tv.setText("PULSADO " + item.getTitle());
                break;
            case MnOp3:
                tv.setText("PULSADO " + item.getTitle());
                break;
            case MnOp4:
                tv.setText("PULSADO " + item.getTitle());
                break;
            case MnOp5:
                tv.setText("PULSADO " + item.getTitle());
                break;
            case MnOp6:
                tv.setText("PULSADO " + item.getTitle());
                break;
            case MnOp7:
                tv.setText("PULSADO " + item.getTitle());
                break;
//            case MnOp2_1:
//                tv.setText("Pulsado " + item.getTitle().toString().toLowerCase());
//                break;
//            case MnOp2_2:
//                tv.setText("Pulsado " + item.getTitle().toString().toLowerCase());
//                break;
//            case MnOp2_3:
//                tv.setText("Pulsado " + item.getTitle().toString().toLowerCase());
//                break;
        }
        return true;
    }
}