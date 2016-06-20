package com.example.dennis.amazichquiz;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class OefenInsecten extends AppCompatActivity {
    private String[] words = {
            "slak", "regenworm", "larve",
            "vlieg","bij","mug",
            "mier", "vlinder", "spin",
            "sprinkhaan", "rups", "wesp",
            "naaktslak", "bloedzuiger", "bidsprinkhaan"
    };

    private String[] translations = {
            "aɣlal", "adan n tmurt", "takecca",
            "iẓi","zizwit","nnamus",
            "tikedfet", "aferṭṭu", "qundɣa ",
            "burxes", "bugḍif", "yaẓẓa",
            "buccel ", "tiḍḍa", "tamraebt"
    };

    private String[] photos = {
            "insecten/insecten_slak.jpg", "insecten/insecten_regenworm.jpg",
            "insecten/insecten_larve.jpg", "insecten/insecten_vlieg.jpg",
            "insecten/insecten_bij.jpg", "insecten/insecten_mug.jpg",
            "insecten/insecten_mier.jpg", "insecten/insecten_vlinder.jpg",
            "insecten/insecten_spin.jpg", "insecten/insecten_sprinkhaan.jpg",
            "insecten/insecten_rups.jpg", "insecten/insecten_wesp.jpg",
            "insecten/insecten_naaktslak.jpg", "insecten/insecten_bloedzuiger.jpg",
            "insecten/insecten_bidsprinkhaan.jpg",
    };

    private int[] audioFiles = {
            R.raw.insecten_slak, R.raw.insecten_regenworm,
            R.raw.insecten_larve, R.raw.insecten_vlieg,
            R.raw.insecten_bij, R.raw.insecten_mug,
            R.raw.insecten_mier, R.raw.insecten_vlinder,
            R.raw.insecten_spin, R.raw.insecten_sprinkhaan,
            R.raw.insecten_rups, R.raw.insecten_wesp,
            R.raw.insecten_naaktslak, R.raw.insecten_bloedzuiger,
            R.raw.insecten_bidsprinkhaan
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
