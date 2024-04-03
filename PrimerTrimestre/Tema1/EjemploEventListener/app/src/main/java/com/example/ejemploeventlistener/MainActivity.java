package com.example.ejemploeventlistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView etiqueta1 = findViewById(R.id.lbl1);
        final TextView etiqueta2 = findViewById(R.id.lbl2);
        final TextView etiqueta3 = findViewById(R.id.lbl3   );
        final TextView etiqueta4 = findViewById(R.id.lbl4);

        final EditText texto = findViewById(R.id.et);

        // Defino el event listener TextChangedListener
        texto.addTextChangedListener(new TextWatcher() {
            // Método que se lanza antes de cambiar el texto
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                etiqueta1.setText(s.toString());

                // Este método es llamado para notidicar que, dentro de s, count caracteres
                //  a partir de start van a ser remplazados por nuevo texto cuya longitud
                //  es after
                etiqueta3.setText(s.toString() + " start: " + start + " count: " + count + " after: " + after);
            }


            // Método que se lanza cuando el texto cambia
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etiqueta2.setText(s.toString());
                etiqueta4.setText(s.toString() + " start: " + start + " before: " + before + " count: " + count);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // No hacemos nada
            }
        });
    }

    public void onClick(View view){
        final TextView etiqueta5 = findViewById(R.id.lbl5);
        int id = view.getId();

        // Seria más optimo usar un switch pero por algún motivo da error
        if(id==R.id.btnAceptar){
            etiqueta5.setText("Aceptar");
        }else if(id==R.id.btnCancelar){
            etiqueta5.setText("Cancelar");
        }
//        switch ((view.getId())){
//            case (R.id.btnAceptar):
//                etiqueta5.setText("Aceptar");
//                break;
//            case (R.id.btnCancelar):
//                etiqueta5.setText("Cancelar");
//                break;
//        }
    }


}