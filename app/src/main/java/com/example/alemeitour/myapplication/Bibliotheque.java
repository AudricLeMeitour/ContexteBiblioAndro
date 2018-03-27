package com.example.alemeitour.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Bibliotheque extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bibliotheque);

        Importation livreImport = new Importation();
        livreImport.execute("http://10.0.2.2:3002/android");
        ListView listeL = (ListView) findViewById(R.id.ListDeLivre);

        try{
            ArrayList<Livre> listeLivreImportee = livreImport.get();
            if(listeLivreImportee != null){
                LivreAdapter adapter = new LivreAdapter(getApplicationContext(), listeLivreImportee);
                listeL.setAdapter(adapter);

            }
            else{
                Log.i("Parseur","Problème lors de la lecture du fichier");
            }
        } catch (InterruptedException e) {
            Log.i("Parseur", "Interruption lecture fichier"+e.getMessage());
        } catch (ExecutionException e) {
            Log.i("Parseur", "Erreur execution"+ e.getMessage());
        }

    }
}



