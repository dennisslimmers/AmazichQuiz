package com.example.dennis.amazichquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OefenMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_oefen);
    }

    public void RedirectOefenDieren(View v) {
        Intent i = new Intent(this, OefenDieren.class);
        startActivity(i);
    }

    public void RedirectOefenFruit(View v) {
        Intent i = new Intent(this, OefenDieren.class);
        startActivity(i);
    }

    public void RedirectOefenInsecten(View v) {
        Intent i = new Intent(this, OefenDieren.class);
        startActivity(i);
    }

    public void RedirectOefenGroente(View v) {
        Intent i = new Intent(this, OefenDieren.class);
        startActivity(i);
    }

    public void RedirectOefenDierenTwee(View v) {
        Intent i = new Intent(this, OefenDieren.class);
        startActivity(i);
    }

    public void RedirectOefenEten(View v) {
        Intent i = new Intent(this, OefenDieren.class);
        startActivity(i);
    }

    public void RedirectOefenKleding(View v) {
        Intent i = new Intent(this, OefenDieren.class);
        startActivity(i);
    }

    public void RedirectOefenWeer(View v) {
        Intent i = new Intent(this, OefenDieren.class);
        startActivity(i);
    }

    public void RedirectOefenKleuren(View v) {
        Intent i = new Intent(this, OefenDieren.class);
        startActivity(i);
    }

}
