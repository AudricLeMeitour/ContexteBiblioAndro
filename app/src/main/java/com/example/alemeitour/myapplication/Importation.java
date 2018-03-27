package com.example.alemeitour.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by alemeitour on 01/12/2017.
 */

class Importation extends AsyncTask<String,Void,ArrayList<Livre>> {
    protected ArrayList<Livre> doInBackground(String... urls) {
        URL url;
        String ligne;
        try {
            ArrayList<Livre> listeLivreImportee;
            url = new URL(String.valueOf(urls[0]));
            InputStream is = url.openConnection().getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader buff = new BufferedReader(isr);
            ligne = buff.readLine();
            ligne = ligne.replace("<p>","");
            ligne = ligne.replace("</p>","");
            Log.i("parseur",ligne);
            Gson gson = new Gson();
            listeLivreImportee = gson.fromJson(ligne,
                                                    new TypeToken<ArrayList<Livre>>(){}.getType());
            return listeLivreImportee;

        } catch (MalformedURLException e) {
            Log.i("Parseur", "URL incorrecte" + e.getMessage());
            return null;
        } catch (IOException e) {
            Log.i("Parseur", "Probleme I/O" + e.getMessage());
            return null;
        }
    }
}