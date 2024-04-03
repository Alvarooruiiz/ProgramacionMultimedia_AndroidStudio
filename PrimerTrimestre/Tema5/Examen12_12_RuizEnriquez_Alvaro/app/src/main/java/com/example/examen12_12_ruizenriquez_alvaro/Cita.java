package com.example.examen12_12_ruizenriquez_alvaro;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Cita extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cita);

        final Intent intent = new Intent(Cita.this, MainActivity.class);
    }
}
