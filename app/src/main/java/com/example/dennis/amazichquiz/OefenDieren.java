package com.example.dennis.amazichquiz;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class OefenDieren extends AppCompatActivity {
    private String[] words = {
        "Egel", "Ezel", "Geit",
        "Hond","Jakhals","Kat",
        "Kikker", "Kip", "Koe",
        "Konijn", "Muis", "Paard",
        "Schaap", "Vis", "Vogel"
    };

    private String[] translations = {
        "Insi", "Aɣyul", "Tɣaṭṭ",
        "Ayḍi","Uccen","Mucc",
        "Aqaqriw", "Tyaziḍt", "Tafunast",
        "Aqninni", "Aɣerda", "Ayis",
        "Icerri", "Aslem", "Agḍiḍ"
    };

    private String[] photos = {
        "dieren1/dieren01_egel.jpg", "dieren1/dieren01_ezel.jpg",
        "dieren1/dieren01_geit.jpg", "dieren1/dieren01_hond.jpg",
        "dieren1/dieren01_jakhals.jpg", "dieren1/dieren01_kat.jpg",
        "dieren1/dieren01_kikker.jpg", "dieren1/dieren01_kip.jpg",
        "dieren1/dieren01_koe.jpg", "dieren1/dieren01_konijn.jpg",
        "dieren1/dieren01_muis.jpg", "dieren1/dieren01_paard.jpg",
        "dieren1/dieren01_schaap.jpg", "dieren1/dieren01_vis.jpg",
        "dieren1/dieren01_vogel.jpg",
    };

    private int[] audioFiles = {
        R.raw.dieren01_egel, R.raw.dieren01_ezel,
        R.raw.dieren01_geit, R.raw.dieren01_hond,
        R.raw.dieren01_jakhals, R.raw.dieren01_kat,
        R.raw.dieren01_kikker, R.raw.dieren01_kip,
        R.raw.dieren01_koe, R.raw.dieren01_konijn,
        R.raw.dieren01_muis, R.raw.dieren01_paard,
        R.raw.dieren01_schaap, R.raw.dieren01_vis,
        R.raw.dieren01_vogel
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

