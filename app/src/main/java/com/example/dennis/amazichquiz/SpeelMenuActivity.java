package com.example.dennis.amazichquiz;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SpeelMenuActivity extends AppCompatActivity {
    private String TAG = "DEBUG";
    public Button dieren1;
    public Button fruit;
    public Button insecten;
    public Button groente;
    public Button dieren2;
    public Button eten;
    public Button kleding;
    public Button kleur;
    public Button weer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_speel);
        dieren1 = (Button) findViewById(R.id.button4);
        fruit = (Button) findViewById(R.id.button5);
        insecten = (Button) findViewById(R.id.button6);
        groente = (Button) findViewById(R.id.button7);
        dieren2 = (Button) findViewById(R.id.button8);
        eten = (Button) findViewById(R.id.button9);
        kleding = (Button) findViewById(R.id.button10);
        kleur = (Button) findViewById(R.id.button11);
        weer = (Button) findViewById(R.id.button12);

        try {
            readDatabase();
        } catch (IOException e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public void readDatabase() throws IOException {
        String str = "";
        File database = new File(Environment.getExternalStorageDirectory().getPath() + "/database.txt");
        BufferedReader reader = new BufferedReader(new FileReader(database));

        while ((str = reader.readLine()) != null) {
            // fetch boolean
            int dashPosition = str.indexOf("-");
            boolean unlocked = Boolean.parseBoolean(str.substring(dashPosition + 1));

            if (unlocked)
                unlockButtons(str);

            Log.d(TAG, unlocked ? "true" : "false");
        }

        reader.close();
    }

    public void unlockButtons(String databaseItem) {
        switch (databaseItem) {
            case "dieren1-true":
                dieren1.setEnabled(true);
                break;
            case "fruit-true":
                fruit.setEnabled(true);
                break;
            case "insecten-true":
                insecten.setEnabled(true);
                break;
            case "groenten-true":
                groente.setEnabled(true);
                break;
            case "dieren2-true":
                dieren2.setEnabled(true);
                break;
            case "eten-true":
                eten.setEnabled(true);
                break;
            case "kleding-true":
                kleding.setEnabled(true);
                break;
            case "kleur-true":
                kleur.setEnabled(true);
                break;
            case "weer-true":
                weer.setEnabled(true);
                break;
        }
    }

    public void RedirectSpeelDieren(View v) {
        Intent i = new Intent(this, SpeelDieren.class);
        startActivity(i);
    }

    public void RedirectSpeelFruit(View v) {
        Intent i = new Intent(this, SpeelFruit.class);
        startActivity(i);
    }

    public void RedirectSpeelInsecten(View v) {
        Intent i = new Intent(this, SpeelInsecten.class);
        startActivity(i);
    }

    public void RedirectSpeelGroente(View v) {
        Intent i = new Intent(this, SpeelGroenten.class);
        startActivity(i);
    }

    public void RedirectSpeelDierenTwee(View v) {
        Intent i = new Intent(this, SpeelDierenTwee.class);
        startActivity(i);
    }

    public void RedirectSpeelEten(View v) {
        Intent i = new Intent(this, SpeelEten.class);
        startActivity(i);
    }

    public void RedirectSpeelKleding(View v) {
        Intent i = new Intent(this, SpeelKleding.class);
        startActivity(i);
    }

    public void RedirectSpeelWeer(View v) {
        Intent i = new Intent(this, SpeelWeer.class);
        startActivity(i);
    }

    public void RedirectSpeelKleuren(View v) {
        Intent i = new Intent(this, SpeelKleding.class);
        startActivity(i);
    }


}
