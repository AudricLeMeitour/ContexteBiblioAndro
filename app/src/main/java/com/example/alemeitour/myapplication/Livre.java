package com.example.alemeitour.myapplication;

import java.util.ArrayList;

/**
 * Created by alemeitour on 01/12/2017.
 */

public class Livre {
    private String _titre;
    private String _resume;


    public Livre(String unTitre, String unAuteur){
        this._titre = unTitre;
        this._resume = unAuteur;

    }

    public String getTitre(){
        return _titre;
    }
    public String getResume(){
        return _resume;
    }

    public static ArrayList<Livre> toutLesLivres = new ArrayList<>();

    public static void setToutLesLivres(ArrayList<Livre> toutLesLivres){
        Livre.toutLesLivres = toutLesLivres;
    }
    public static void addLivre(String Titre, String Auteur){
        toutLesLivres.add(new Livre(Titre, Auteur));
    }
}
