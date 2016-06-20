package com.example.dennis.amazichquiz;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class OefenKleding extends AppCompatActivity {
    private String[] words = {
            "broek", "trui", "onderhemd",
            "jas","schoenen","laarzen",
            "muts", "jurk", "rok",
            "slippers", "handschoenen", "sokken",
            "overhemd", "sjaal", "riem"
    };

    private String[] translations = {
            "ssarwal", "amaryul", "camisita ",
            "aqabud","tisila","ihakusen",
            "tcaccict", "tablust", "farda",
            "tcinklat", "iwantisan", "tqacir",
            "taqmijjat", "ahewwak", "abyas"
    };

    private String[] photos = {
            "kleding/kleding_broek.jpg", "kleding/kleding_trui.jpg",
            "kleding/kleding_onderhemd.jpg", "kleding/kleding_jas.jpg",
            "kleding/kleding_schoenen.jpg", "kleding/kleding_laarzen.jpg",
            "kleding/kleding_muts.jpg", "kleding/kleding_jurk.jpg",
            "kleding/kleding_rok.jpg", "kleding/kleding_slippers.jpg",
            "kleding/kleding_handschoenen.jpg", "kleding/kleding_sokken.jpg",
            "kleding/kleding_overhemd.jpg", "kleding/kleding_sjaal.jpg",
            "kleding/kleding_riem.jpg",
    };

    private int[] audioFiles = {
            R.raw.kleding_broek, R.raw.kleding_trui,
            R.raw.kleding_onderhemd, R.raw.kleding_jas,
            R.raw.kleding_schoenen, R.raw.kleding_laarzen,
            R.raw.kleding_muts, R.raw.kleding_jurk,
            R.raw.kleding_rok, R.raw.kleding_slippers,
            R.raw.kleding_handschoenen, R.raw.kleding_sokken,
            R.raw.kleding_overhemd, R.raw.kleding_sjaal,
            R.raw.kleding_riem
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
