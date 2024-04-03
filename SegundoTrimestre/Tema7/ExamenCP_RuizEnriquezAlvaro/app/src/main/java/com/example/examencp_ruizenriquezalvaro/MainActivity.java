package com.example.examencp_ruizenriquezalvaro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.examencp_ruizenriquezalvaro.AdaptadorLista.AdaptadorLista;
import com.example.examencp_ruizenriquezalvaro.AdaptadorLista.SuperHeroe;
import com.example.examencp_ruizenriquezalvaro.AdaptadorSpinner.AdaptadorSpinner;
import com.example.examencp_ruizenriquezalvaro.AdaptadorSpinner.ImagenesAvatar;
import com.example.examencp_ruizenriquezalvaro.BaseDatos.SuperHeroeProvider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvLista;
    private Button btnAdd;
    private Button btnModificar;
    private Button btnCancelar;
    int avatarSelecionado;
    int superHeroeSeleccionado;
    Spinner spinner;
    LinearLayout linearLayout;

    private AdaptadorLista adaptadorLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvLista = findViewById(R.id.lvLista);
        EditText etNombre=findViewById(R.id.etNombre);
        EditText etTelefono=findViewById(R.id.etTelefono);
        ImageButton imageButton = findViewById(R.id.imageButton);
        spinner = findViewById(R.id.spinner);
        linearLayout = findViewById(R.id.llayout);
        registerForContextMenu(lvLista);

        rellenarSpinner();
        listar();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.VISIBLE);
                btnAdd.setVisibility(View.VISIBLE);
                btnCancelar.setVisibility(View.VISIBLE);
                btnModificar.setVisibility(View.GONE);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                avatarSelecionado = ((ImagenesAvatar) parent.getItemAtPosition(position)).getAvatar();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etNombre.getText().toString().isEmpty() && !etTelefono.getText().toString().isEmpty()) {
                    ContentValues values = new ContentValues();
                    values.put(SuperHeroeProvider.SuperHeroes.COL_NOMBRE, etNombre.getText().toString());
                    values.put(SuperHeroeProvider.SuperHeroes.COL_TELEFONO, etTelefono.getText().toString());
                    values.put(SuperHeroeProvider.SuperHeroes.COL_AVATAR, avatarSelecionado);

                    ContentResolver cr2 = getContentResolver();
                    cr2.insert(SuperHeroeProvider.CONTENT_URI, values);
                    etNombre.setText("");
                    etTelefono.setText("");
                }
                listar();
            }
        });


        btnModificar = findViewById(R.id.btnModificar);
        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put(SuperHeroeProvider.SuperHeroes.COL_NOMBRE, etNombre.getText().toString());
                values.put(SuperHeroeProvider.SuperHeroes.COL_TELEFONO, etTelefono.getText().toString());
                values.put(SuperHeroeProvider.SuperHeroes.COL_AVATAR, avatarSelecionado);

                ContentResolver cr2 = getContentResolver();
                cr2.update(SuperHeroeProvider.CONTENT_URI, values,SuperHeroeProvider.SuperHeroes._ID + "=" + superHeroeSeleccionado, null);
                etNombre.setText("");
                etTelefono.setText("");

                listar();
            }
        });


        btnCancelar = findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.GONE);
                btnAdd.setVisibility(View.GONE);
                btnModificar.setVisibility(View.GONE);
                btnCancelar.setVisibility(View.GONE);
            }
        });


        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adaptador, View view, int position, long id) {
                superHeroeSeleccionado = ((SuperHeroe) adaptador.getItemAtPosition(position)).getIndice();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        int position=info.position;
        SuperHeroe superHeroe = (SuperHeroe) adaptadorLista.getItem(position);
        superHeroeSeleccionado= superHeroe.getIndice();

        if(item.getItemId()==R.id.opActualizar){
            lvLista.setVisibility(View.VISIBLE);
            btnAdd.setVisibility(View.GONE);
            btnCancelar.setVisibility(View.VISIBLE);
            btnModificar.setVisibility(View.VISIBLE);
            listar();
            return true;
        }else if(item.getItemId()==R.id.opBorrar){
            ContentResolver cr = getContentResolver();
            cr.delete(SuperHeroeProvider.CONTENT_URI, SuperHeroeProvider.SuperHeroes._ID + "=" + superHeroeSeleccionado, null);
            listar();
            return true;
        }else{
            return super.onContextItemSelected(item);
        }
    }

    private void rellenarSpinner(){
        ArrayList<ImagenesAvatar> imagenes = new ArrayList<>();
        AdaptadorSpinner adaptador = new AdaptadorSpinner(imagenes,MainActivity.this);
        imagenes.add(new ImagenesAvatar(R.drawable.batman));
        imagenes.add(new ImagenesAvatar(R.drawable.capi));
        imagenes.add(new ImagenesAvatar(R.drawable.deadpool));
        imagenes.add(new ImagenesAvatar(R.drawable.furia));
        imagenes.add(new ImagenesAvatar(R.drawable.hulk));
        imagenes.add(new ImagenesAvatar(R.drawable.ironman));
        imagenes.add(new ImagenesAvatar(R.drawable.lobezno));
        imagenes.add(new ImagenesAvatar(R.drawable.spiderman));
        imagenes.add(new ImagenesAvatar(R.drawable.thor));
        imagenes.add(new ImagenesAvatar(R.drawable.wonderwoman));
        spinner.setAdapter(adaptador);
    }

    private void listar(){
        String[] columnas = new String[]{
                SuperHeroeProvider.SuperHeroes._ID,
                SuperHeroeProvider.SuperHeroes.COL_NOMBRE,
                SuperHeroeProvider.SuperHeroes.COL_TELEFONO,
                SuperHeroeProvider.SuperHeroes.COL_AVATAR
        };
        Uri versionesUri = SuperHeroeProvider.CONTENT_URI;
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(versionesUri,
                columnas,
                null,
                null,
                null);
        SuperHeroe objetoDato;

        ArrayList<SuperHeroe> datos = new ArrayList<>();
        adaptadorLista = new AdaptadorLista(this,datos);
        if (cur != null) {
            if (cur.moveToFirst()) {
                int colId = cur.getColumnIndex(SuperHeroeProvider.SuperHeroes._ID);
                int colNom = cur.getColumnIndex(SuperHeroeProvider.SuperHeroes.COL_NOMBRE);
                int colTel = cur.getColumnIndex(SuperHeroeProvider.SuperHeroes.COL_TELEFONO);
                int colAva=cur.getColumnIndex(SuperHeroeProvider.SuperHeroes.COL_AVATAR);

                do {
                    int id = cur.getInt(colId);
                    String nombre = cur.getString(colNom);
                    String telefono=cur.getString(colTel);
                    int avatar = cur.getInt(colAva);
                    objetoDato = new SuperHeroe(id, nombre,telefono,avatar);
                    datos.add(objetoDato);
                } while (cur.moveToNext());
            }
        }
        lvLista.setAdapter(adaptadorLista);
    }
}