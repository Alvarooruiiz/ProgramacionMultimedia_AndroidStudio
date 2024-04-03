package com.example.examencp_ruizenriquezalvaro.AdaptadorLista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.examencp_ruizenriquezalvaro.R;

import java.util.ArrayList;

public class AdaptadorLista extends BaseAdapter {

    private ArrayList<SuperHeroe> superHeroes;
    private Context contexto;

    public AdaptadorLista(Context contexto, ArrayList<SuperHeroe> superHeroes){
        super();
        this.contexto = contexto;
        this.superHeroes = superHeroes;
    }

    public AdaptadorLista(View.OnClickListener onClickListener, ArrayList<SuperHeroe> superHeroes) {
        super();
        this.contexto = contexto;
        this.superHeroes = superHeroes;
    }

    @Override
    public int getCount() {
        return superHeroes.size();
    }

    @Override
    public Object getItem(int i) {
        return superHeroes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater mostrado = LayoutInflater.from(contexto);
        View elemento = mostrado.inflate(R.layout.lista_superheroes, viewGroup, false);

        ImageView avatar = elemento.findViewById(R.id.avatar);
        avatar.setImageResource(superHeroes.get(i).getAvatar());

        TextView nombre = (TextView) elemento.findViewById(R.id.nombre);
        nombre.setText(superHeroes.get(i).getNombre());

        TextView telefono = (TextView) elemento.findViewById(R.id.telefono);
        telefono.setText(superHeroes.get(i).getTelefono());

        return elemento;
    }
}
