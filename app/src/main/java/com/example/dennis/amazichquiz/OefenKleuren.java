package com.example.dennis.amazichquiz;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class OefenKleuren extends AppCompatActivity {
    private String[] words = { //todo: Al deze arrays zijn gevult met 10 str. Werkt dit met de rest? Oefen werkt wel.
            "rood", "geel", "blauw",
            "zwart","wit","bruin",
            "groen", "oranje", "bont",
            "paars"
    };

    private String[] translations = {
            "azegg-aɣ", "awraɣ", "aḥmaymi",
            "abarcan","acemlal","ahemruni",
            "aziza", "aletcini", "akarkac",
            "azbaybi"
    };

    private String[] photos = {
            "kleuren/kleuren_rood.jpg", "kleuren/kleuren_geel.jpg",
            "kleuren/kleuren_blauw.jpg", "kleuren/kleuren_zwart.jpg",
            "kleuren/kleuren_wit.jpg", "kleuren/kleuren_bruin.jpg",
            "kleuren/kleuren_groen.jpg", "kleuren/kleuren_oranje.jpg",
            "kleuren/kleuren_bont.jpg", "kleuren/kleuren_paars.jpg"
    };

    private int[] audioFiles = {
            R.raw.kleuren_rood, R.raw.kleuren_geel,
            R.raw.kleuren_blauw, R.raw.kleuren_zwart,
            R.raw.kleuren_wit, R.raw.kleuren_bruin,
            R.raw.kleuren_groen, R.raw.kleuren_oranje,
            R.raw.kleuren_bont, R.raw.kleuren_paars
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
