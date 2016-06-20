package com.example.dennis.amazichquiz;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class OefenGroente extends AppCompatActivity {
    private String[] words = {
            "kikkererwten", "linzen", "bonen",
            "tomaat","olijven","aardappel",
            "ui", "knoflook", "maïs",
            "paprika", "pompoen", "wortel",
            "erwten", "tuinbonen", "spinazie"
    };

    private String[] translations = {
            "rḥimez", "leɛdes", "llubeyyet",
            "ttumatic","zzitun","baṭaṭa",
            "rebser", "ticcart", "dra",
            "rferfer", "taxsact", "xizzu",
            "tinifin", "ibawen", "ṭebi"
    };

    private String[] photos = {
            "groente/groente_kikkererwten.jpg", "groente/groente_linzen.jpg",
            "groente/groente_bonen.jpg", "groente/groente_tomaat.jpg",
            "groente/groente_olijven.jpg", "groente/groente_aardappel.jpg",
            "groente/groente_ui.jpg", "groente/groente_knoflook.jpg",
            "groente/groente_mais.jpg", "groente/groente_paprika.jpg",
            "groente/groente_pompoen.jpg", "groente/groente_wortel.jpg",
            "groente/groente_doperwten.jpg", "groente/groente_tuinbonen.jpg",
            "groente/groente_spinazie.jpg",
    };

    private int[] audioFiles = {
            R.raw.groente_kikkererwten, R.raw.groente_linzen,
            R.raw.groente_bonen, R.raw.groente_tomaat,
            R.raw.groente_olijven, R.raw.groente_tomaat,
            R.raw.groente_ui, R.raw.groente_knoflook,
            R.raw.groente_mais, R.raw.groente_paprika,
            R.raw.groente_pompoen, R.raw.groente_wortel,
            R.raw.groente_doperwten, R.raw.groente_tuinbonen,
            R.raw.groente_spinazie
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
