package com.example.actividad5_tema5;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorContacto extends ArrayAdapter<Contacto> {

    public AdaptadorContacto(Context context, List<Contacto> contactos) {
        super(context, 0, contactos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtiene el objeto Contacto para esta posición
        Contacto contacto = getItem(position);

        // Reutiliza la vista si está disponible; de lo contrario, infla una nueva vista
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contacto, parent, false);
        }

        // Referencias a los elementos de la vista
        TextView cabeceraTextView = convertView.findViewById(R.id.cabeceraTextView);
        TextView nombreTextView = convertView.findViewById(R.id.nombreTextView);
        TextView telefonoTextView = convertView.findViewById(R.id.telefonoTextView);

        // Establece los valores en los elementos de la vista
        if (position == 0) {
            cabeceraTextView.setVisibility(View.VISIBLE);
            cabeceraTextView.setText("AGENDA TELEFÓNICA");
        } else {
            cabeceraTextView.setVisibility(View.GONE);
        }

        nombreTextView.setText(contacto.getNombre());
        telefonoTextView.setText(contacto.getTelefono());

        return convertView;
    }
}