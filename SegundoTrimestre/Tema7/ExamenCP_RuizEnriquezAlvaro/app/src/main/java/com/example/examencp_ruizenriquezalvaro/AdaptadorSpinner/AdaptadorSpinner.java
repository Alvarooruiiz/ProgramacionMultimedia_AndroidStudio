package com.example.examencp_ruizenriquezalvaro.AdaptadorSpinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.examencp_ruizenriquezalvaro.R;

import java.util.ArrayList;

public class AdaptadorSpinner extends BaseAdapter {

    private ArrayList<ImagenesAvatar> imagenesAvatares;
    private Context contexto;

    public AdaptadorSpinner(ArrayList<ImagenesAvatar> imagenesAvatares, Context contexto) {
        this.imagenesAvatares = imagenesAvatares;
        this.contexto = contexto;
    }

    public AdaptadorSpinner(View.OnClickListener onClickListener, ArrayList<ImagenesAvatar> datos) {
        super();
        this.imagenesAvatares = imagenesAvatares;
        this.contexto = contexto;
    }


    @Override
    public int getCount() {
        return imagenesAvatares.size();
    }

    @Override
    public Object getItem(int i) {
        return imagenesAvatares.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater mostrado = LayoutInflater.from(contexto);
        View elemento = mostrado.inflate(R.layout.lista_avatares, viewGroup, false);

        ImageView avatar = elemento.findViewById(R.id.avatar);
        avatar.setImageResource(imagenesAvatares.get(i).getAvatar());

        return elemento;
    }
}
