package com.example.practicaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner sp = new Spinner(R.id.spinnerPersonalizado);

        DatosSpinner[] datosSpinner = new DatosSpinner[]{
            new DatosSpinner(R.drawable.batman,"Batman"),
            new DatosSpinner(R.drawable.capi,"Capitan America"),
        };


    }
}