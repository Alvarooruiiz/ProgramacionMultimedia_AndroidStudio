package com.example.tema4;

import static com.example.tema4.R.id.imgBtn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class Trato  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trato_layout);
        final TextView tvFantasma = findViewById(R.id.tvFantasma);
        final TextView tvCalabaza = findViewById(R.id.tvCalabaza);
//        final ImageButton btn = findViewById(R.id.imgBtn);
        final Intent intent = new Intent(Trato.this, MainActivity.class);

        tvFantasma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                btn.setImageResource(R.drawable.fantasma);
                startActivity(intent);
            }
        });

        tvCalabaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                btn.setImageResource(R.drawable.calabaza);
                startActivity(intent);
            }
        });
    }
}
