package com.example.ejemplocompleto;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SCREEN2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnScreen1 = findViewById(R.id.btnScreen1);
        btnScreen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Screen2Activity.class);
                startActivityForResult(intent, REQUEST_CODE_SCREEN2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SCREEN2 && resultCode == RESULT_OK) {
            // El resultado proviene de Screen2Activity
            if (data != null) {
                boolean changeBackground = data.getBooleanExtra("CHANGE_BACKGROUND", false);
                if (changeBackground) {
                    // Cambia el fondo de MainActivity
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                }
            }
        }
    }
}