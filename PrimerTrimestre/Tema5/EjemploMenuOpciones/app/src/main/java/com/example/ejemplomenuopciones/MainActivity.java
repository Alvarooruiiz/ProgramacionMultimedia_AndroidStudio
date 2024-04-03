package com.example.ejemplomenuopciones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private static final int MnOp1 = 1;
    private static final int MnOp2 = 2;
    private static final int MnOp3 = 3;
    private static final int mnOp2_1 = 4;
    private static final int mnOp2_2 = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    // ------ Creo menu con java ------


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,MnOp1,menu.NONE,"Opcion A desde Java");

        SubMenu smnu = menu.addSubMenu(Menu.NONE,MnOp2,Menu.NONE,"Opción B desde java");
        smnu.add(Menu.NONE,mnOp2_1,Menu.NONE,"Opción B.1 desde Java");
        smnu.add(Menu.NONE,mnOp2_2,Menu.NONE,"Opción B.2 desde Java");

        menu.add(Menu.NONE,MnOp3,menu.NONE,"Opcion C desde Java");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case MnOp1:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case MnOp2:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case MnOp3:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case mnOp2_1:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case mnOp2_2:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_principal,menu);
//        return true;
//    }

//    // ------ Creo menu desde XML ------
//        @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int opcion = item.getItemId();
//
//        // Como en el ejemplo voy a hacer lo mismo en todas las opciones del menú, no voy a separar
//        // las distintas opciones en un else if
//
//        if(opcion == R.id.mnOp1 || opcion == R.id.mnOp2 || opcion == R.id.mnOp3 || opcion == R.id.mnOp2_1 || opcion == R.id.mnOp2_2){
//            Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}