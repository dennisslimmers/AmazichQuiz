package com.example.dennis.amazichquiz;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class OefenWeer extends AppCompatActivity {
    private String[] words = {
            "lente", "zomer", "herfst",
            "winter","regen","sneeuw",
            "wind", "regenboog", "maan",
            "zon", "halvemaan", "donder",
            "ster", "mist", "wolken"
    };

    private String[] translations = {
            "tafsut", "anebdu", "leiglief",
            "tajarst","anẓar","adfel",
            "asemmiḍ taslit n", "unzar", "yur",
            "tfuct", "taziri", "ajjaj",
            "itri", "tayyut", "asinu"
    };

    private String[] photos = {
            "weer/weer_lente.jpg", "weer/weer_zomer.jpg",
            "weer/weer_herfst.jpg", "weer/weer_winter.jpg",
            "weer/weer_regen.jpg", "weer/weer_sneeuw.jpg",
            "weer/weer_wind.jpg", "weer/weer_regenboog.jpg",
            "weer/weer_maan.jpg", "weer/weer_zon.jpg",
            "weer/weer_halvemaan.jpg", "weer/weer_donder.jpg",
            "weer/weer_ster.jpg", "weer/weer_mist.jpg",
            "weer/weer_wolken.jpg",
    };

    private int[] audioFiles = {
            R.raw.weer_lente, R.raw.weer_zomer,
            R.raw.weer_herfst, R.raw.weer_winter,
            R.raw.weer_regen, R.raw.weer_sneeuw,
            R.raw.weer_wind, R.raw.weer_regenboog,
            R.raw.weer_maan, R.raw.weer_zon,
            R.raw.weer_halvemaan, R.raw.weer_donder,
            R.raw.weer_ster, R.raw.weer_mist,
            R.raw.weer_wolken
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
