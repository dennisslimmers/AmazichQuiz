package com.example.dennis.amazichquiz;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class OefenFruit extends AppCompatActivity {
    private String[] words = {
            "appel", "peer", "abrikoos",
            "perzik","druiven","watermeloen",
            "honingmeloen", "granaatappel", "vijg",
            "cactusvijg", "pruim", "sinaasappel",
            "dadel", "citroen", "bananen"
    };

    private String[] translations = {
            "tateffaht", "tafirast", "rmecmac",
            "rxux","aḍil","ddellaɛ",
            "abettix", "arremman", "tazart",
            "tahendict", "rbarquq", "taleccint",
            "tini", "llaymun", "banan"
    };

    private String[] photos = {
            "fruit/fruit_appel.jpg", "fruit/fruit_peer.jpg",
            "fruit/fruit_abrikoos.jpg", "fruit/fruit_perzik.jpg",
            "fruit/fruit_druiven.jpg", "fruit/fruit_watermeloen.jpg",
            "fruit/fruit_honingmeloen.jpg", "fruit/fruit_granaatappel.jpg",
            "fruit/fruit_vijg.jpg", "fruit/fruit_cactusvijg.jpg",
            "fruit/fruit_pruim.jpg", "fruit/fruit_sinaasappel.jpg",
            "fruit/fruit_dadel.jpg", "fruit/fruit_citroen.jpg",
            "fruit/fruit_bananen.jpg",
    };

    private int[] audioFiles = {
            R.raw.fruit_appel, R.raw.fruit_peer,
            R.raw.fruit_abrikoos, R.raw.fruit_perzik,
            R.raw.fruit_druiven, R.raw.fruit_watermeloen,
            R.raw.fruit_honingmeloen, R.raw.fruit_granaatappel,
            R.raw.fruit_vijg, R.raw.fruit_cactusvijg,
            R.raw.fruit_pruim, R.raw.fruit_sinaasappel,
            R.raw.fruit_dadel, R.raw.fruit_citroen,
            R.raw.fruit_bananen
    };

    TextView wordView;
    TextView translationView;
    ImageView photoView;
    SwipeListener sl;
    MediaPlayer m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oefen_dieren);

        wordView = (TextView) findViewById(R.id.textView);
        photoView = (ImageView) findViewById(R.id.animalView);
        translationView = (TextView) findViewById(R.id.textView2);

        sl = new SwipeListener(words, translations, photos, audioFiles, wordView, translationView, photoView, this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return sl.gestureDetector.onTouchEvent(event);
    }
}
