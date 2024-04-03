package com.example.ejemploscontrolesbasicos2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ejemplo Spinner
        final Spinner spinner = findViewById(R.id.miSpinner);
        String[] valores = {"Valor 1","Valor 2","Valor 3","Valor 4","Valor 5"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,valores));

        //Recupero el contenido del elemento seleccionado y lo pongo en el TextView
        final TextView texto = findViewById(R.id.txt1);
        String valor = spinner.getSelectedItem().toString();
        texto.setText(valor);

        //Creo un manejador de eventos para que cuando cambie de opción lo pille
            //Creo un adapter para poder usarlo con el manejador     de eventos
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adaptador, View view, int position, long id) {
                String cadena = (String) adaptador.getItemAtPosition(position);
                texto.setText(cadena);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Creo el adaptador para el segundo spinner
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.valores, android.R.layout.simple_spinner_item);
        final Spinner spinner2 = findViewById(R.id.miSpinner2);
        spinner2.setAdapter(adaptador);

        //--------------  CHECKBOX  -----------------
        final TextView texto2 = findViewById(R.id.lbl1);
        final CheckBox checkBox = findViewById(R.id.miCheck);

        //Creo el listener para el checkBox
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    texto2.setText("Seleccionado");
                }else texto2.setText("Deseleccionado");
            }
        });

        //-------------  RadioGroup  ---------------
        final RadioGroup miGrupo = findViewById(R.id.grupo);

        // Manejador de eventos para el radioGroup
        miGrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                final RadioButton rb = findViewById(checkedId);
                String texto = rb.getText().toString();
                texto2.setText(texto);
            }
        });

        // -------------  Switch -------------

        //Manejador de switch
        final Switch pulsador = findViewById(R.id.miSwitch);
        pulsador.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean pulsado) {
               if(pulsado){
                   texto2.setText("Switch marcado");
               }else texto2.setText("Switch desmarcado");
            }
        });

        // ----------  RatingBar  --------------
        final RatingBar puntuacion = findViewById(R.id.miRating);
        puntuacion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                texto2.setText("Valor en rating cambiado: " + rating);
            }
        });

        // ----------  SeekBar  -----------
        final SeekBar miControl = findViewById(R.id.miSeekBar);

        miControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progreso, boolean fromUser) {
                final TextView etiqueta = findViewById(R.id.lblSeek);

                texto2.setText("Texto cambiado en SeekBar " + progreso);
                //Se hace transparente o opaco según el proceso
                etiqueta.setAlpha(progreso/60f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                texto2.setText("Inicio de cambio de texto en SeekBar");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                texto2.setText("Final del cambio de texto en SeekBar");
            }
        });


    }
}