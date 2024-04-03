package com.example.practicaevaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        actividad1();
//        actividad2();
        actividad3();

    }

    public void actividad1() {
        setContentView(R.layout.actividad1);
        final ImageView img = findViewById(R.id.img);
        final TextView tv = findViewById(R.id.txtBienvenido);
        final Switch osc = findViewById(R.id.swtOscuro);
        final RelativeLayout rl = findViewById(R.id.fondo);

        osc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean pulsado) {
                if (pulsado) {
                    tv.setTextColor(Color.WHITE);
                    rl.setBackgroundColor(Color.BLACK);
                    img.setBackgroundColor(Color.BLACK);
                    final ImageView imagen = findViewById(R.id.imgModo);
                    imagen.setImageResource(R.drawable.img_1);
                } else {
                    tv.setTextColor(Color.BLACK);
                    rl.setBackgroundColor(Color.WHITE);
                    img.setBackgroundColor(Color.WHITE);
                    final ImageView imagen = findViewById(R.id.imgModo);
                    imagen.setImageResource(R.drawable.img);
                }
            }
        });

    }


    public void actividad2(){
        setContentView(R.layout.actividad2);
        final TextView textoRecordatorio = findViewById(R.id.txtRecordatorio);

        final Button btnAceptar = findViewById(R.id.btnAceptar);
        final CheckBox cb = findViewById(R.id.cbRecor);
        final EditText etNomb = findViewById(R.id.etNombre);
        final EditText etFecNac = findViewById(R.id.etFecNac);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = etNomb.getText().toString();
                String fechaNac = etFecNac.getText().toString();
                if(nombre.equals("")){
                    textoRecordatorio.setText("ERROR: No has escrito el nombre");
                }else if (cb.isChecked()){
                    textoRecordatorio.setText("¡Hola " + nombre + "! Has nacido el " + fechaNac + ". Se ha creado un recordatorio");
                }else {
                    textoRecordatorio.setText("");
                }
            }
        });



    }


    public void actividad3(){
        setContentView(R.layout.actividad3);
        final Button btnEnviar = findViewById(R.id.btnEnviar);
        final TextView txtNom = findViewById(R.id.txtNombreUsuario);
        final TextView txtRese = findViewById(R.id.txtResena);
        final RatingBar miRatin = findViewById(R.id.miRating);
        final Spinner cuentaSpinner = findViewById(R.id.spnTipoCuenta);
        String[] valores = {"Cuenta personal", "Cuenta de empresa" , "Cuenta estudiante"};
        cuentaSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,valores));



        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtRese.setText("");
                txtNom.setText("");
                miRatin.setRating(2);
                Toast.makeText(MainActivity.this,"Eviado corrextamente",Toast.LENGTH_SHORT).show();
            }
        });

        cuentaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Se ha seleccionado el tipo de cuenta",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}