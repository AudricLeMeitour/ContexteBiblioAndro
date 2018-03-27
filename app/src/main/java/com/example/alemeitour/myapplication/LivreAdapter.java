package com.example.alemeitour.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alemeitour on 01/12/2017.
 */

public class LivreAdapter extends BaseAdapter {
    private List<Livre> livreList;
    private LayoutInflater inflater;

    public LivreAdapter(Context context, List<Livre> listL){
        this.inflater = LayoutInflater.from(context);
        this.livreList = listL;
    }
    public int getCount() {
        int nombreElement = livreList.size();
        return nombreElement;
    }

    @Override
    public Livre getItem(int i) {

        return livreList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return (i);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        TextView Titre;
        TextView Auteur;
        TextView Genre;
        if(convertView ==null){
            convertView = this.inflater.inflate(R.layout.vue_livre, parent, false);
            Titre = (TextView) convertView.findViewById(R.id.textViewTitre);
            Auteur = (TextView) convertView.findViewById(R.id.textViewAuteur);
            Genre = (TextView) convertView.findViewById(R.id.textViewGenre);
            convertView.setTag(R.id.textViewTitre, Titre);
            convertView.setTag(R.id.textViewAuteur, Auteur);
            convertView.setTag(R.id.textViewGenre, Genre);
        }else {
            Titre = (TextView) convertView.getTag(R.id.textViewTitre);
            Auteur = (TextView) convertView.getTag(R.id.textViewAuteur);
            Genre = (TextView) convertView.getTag(R.id.textViewGenre);
        }
        Livre exo = this.getItem(position);
        Titre.setText(exo.getTitre());
        Auteur.setText(exo.getResume());
    //    Genre.setText(exo.getGenre());
        return convertView;
}

}


