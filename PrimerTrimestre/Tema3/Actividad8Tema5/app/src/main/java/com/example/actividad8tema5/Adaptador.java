package com.example.actividad8tema5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adaptador extends ArrayAdapter<Datos> {

    private Context context;
    private int resource;
    private List<Datos> itemList;

    public Adaptador(Context context, int resource, List<Datos> itemList) {
        super(context, resource, itemList);
        this.context = context;
        this.resource = resource;
        this.itemList = itemList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            listItemView = inflater.inflate(resource, parent, false);
        }

        // Obtener el elemento actual
        Datos currentItem = itemList.get(position);

        // Configurar el CheckBox
        CheckBox checkBox = listItemView.findViewById(R.id.checkBox);
        checkBox.setChecked(currentItem.isSelected());

        // Configurar la imagen
        ImageView imageView = listItemView.findViewById(R.id.imageView);
        imageView.setImageResource(currentItem.getImagenResId());

        // Configurar el nombre
        TextView nombreTextView = listItemView.findViewById(R.id.nombreTextView);
        nombreTextView.setText(currentItem.getNombre());

        return listItemView;
    }
}