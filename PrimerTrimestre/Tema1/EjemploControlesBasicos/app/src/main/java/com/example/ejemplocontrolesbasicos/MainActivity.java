package com.example.ejemplocontrolesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv12_linearlayout_gridlayout);

        final TextView etiqueta1 = findViewById(R.id.lbl1);
        //Actividad 12
        final GridLayout layoutCheck = findViewById(R.id.layoutCheck);
        for(int i=0; i< layoutCheck.getChildCount(); i++) {
            CheckBox miCheck = (CheckBox) layoutCheck.getChildAt(i);
            if (miCheck.isChecked()) {
                etiqueta1.setText("a");
            }

        }

        final Button miBotonReset = findViewById(R.id.btnResetear);
        miBotonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i< layoutCheck.getChildCount(); i++) {
                    CheckBox miCheck = (CheckBox) layoutCheck.getChildAt(i);

                    }

                }

            });
        }


            //Actividad 12


            //Creo el listener para el checkBox





//Ejercicio 10
//        final Button miBotonReset = findViewById(R.id.btnReset);
//        final EditText txtNombre = findViewById(R.id.nombre);
//        final EditText txtClave = findViewById(R.id.clave);
//        miBotonReset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                txtNombre.setText("");
//                txtClave.setText("");
//            }
//        });

//        //Busco el id de las etiquetas
//        //Si da error al escribir el nombre de las lbl es porqeu es necesario ejecutarlo
//        final TextView etiq1 = findViewById(R.id.lbl1);
//        final TextView etiq7 = findViewById(R.id.lbl7);
//
//
//        String texto = etiq1.getText().toString();
//        etiq7.setText(texto + " copiado de lbl1");
//
//        final TextView etiqBtn = findViewById(R.id.textBtn);
//        final Button miBoton = findViewById(R.id.btn1);
//
//        miBoton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                etiqBtn.setText("Pulsando boton simple");
//            }
//        });
//
//        //Creamos el manejador del toggle button
//        final ToggleButton miToggleButton = findViewById(R.id.togggleBtn);
//
//        miToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                if (isChecked) {
//                    etiqBtn.setText("ToggleButton activado");
//                } else etiqBtn.setText("ToggleButton desactivado");
//            }
//        });
//
//        //Creamos el manejador boton con imagen
//        final ImageButton img = findViewById(R.id.imgBtn);
//
//        //Establecemos una imagen en el segundo boton desde java
//        final ImageButton img2 = findViewById(R.id.imgBtn2);
//        img2.setImageResource(R.drawable.pulsa);
//
//        //Creo el manejador de eventos para Btn2
//        img2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                img.setImageResource(R.drawable.feliz);
//            }
//        });
//
//        //Añado imagenes
//        final ImageView imagen = findViewById(R.id.img2);
//        imagen.setImageResource(R.drawable.android);
//
//
//        //-----AutoCompleteTextView-----
//        //Creamos los datos para el actw
//
//        String[] opciones = {"opcion1","opcion2","opcion3","opcion4","opcion5"};
//        final AutoCompleteTextView textoLeido = findViewById(R.id.acText);
//        //contexto,como quiero que se muestre, que quiero que se muestre
//        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, opciones);
//        textoLeido.setAdapter(adaptador);
//
//        //-----MultiAutocompleteTextView-----
//        final MultiAutoCompleteTextView textoLeido2 = findViewById(R.id.acText2);
//
//        ArrayAdapter<String> adaptador2 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,opciones);
//        textoLeido2.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
//        textoLeido2.setAdapter(adaptador2);

    }
