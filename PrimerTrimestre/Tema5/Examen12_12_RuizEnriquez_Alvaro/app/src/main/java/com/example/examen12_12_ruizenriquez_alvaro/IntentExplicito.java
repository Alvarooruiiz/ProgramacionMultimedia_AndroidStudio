package com.example.examen12_12_ruizenriquez_alvaro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class IntentExplicito extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intentexplicito);
        final Button btnVolver = findViewById(R.id.btnVolver);
        final ImageView imageView = findViewById(R.id.imagen);
        final Intent intent = new Intent(IntentExplicito.this, MainActivity.class);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
