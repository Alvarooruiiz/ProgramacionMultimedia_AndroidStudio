package com.example.ejeplocomunicacionactividades;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtengo los datos al pulsar el boton
        final EditText etNombre = findViewById(R.id.etNombre);
        final Button btnVerificar = findViewById(R.id.btnVerificar);
        final TextView lblResultado = findViewById(R.id.lblResultado);

        //Recogemos los datos de la actividad 2
        ActivityResultLauncher resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                    Intent intent = result.getData();

                    if(intent!=null){
                        Bundle extras = intent.getExtras();
                        String resultado = extras.getString("boton_pulsado");
                        lblResultado.setText(resultado);
                    }
                }
            }
        });

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = etNombre.getText().toString();

                //Llamo a la nueva actividad y le paso datos
                Intent intent_condiciones = new Intent(MainActivity.this,CondicionesUso.class);
                intent_condiciones.putExtra("usuario",usuario);
//                startActivity(intent_condiciones);
                resultLauncher.launch(intent_condiciones);

            }
        });


    }


}