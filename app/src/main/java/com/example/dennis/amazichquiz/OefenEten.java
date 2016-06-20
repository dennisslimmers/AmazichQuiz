package com.example.dennis.amazichquiz;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class OefenEten extends AppCompatActivity {
    private String[] words = {
            "Eieren", "olie", "koekjes",
            "thee","koffie","melk",
            "yoghurt", "water", "brood",
            "honing", "suiker", "zout",
            "vlees", "vissen", "boter"
    };

    private String[] translations = {
            "timejjalin", "zzict", "ɣayiṭa",
            "atay","rqehwa","aɣi",
            "accil", "aman", "aɣrum",
            "tamment", "sseqqur", "tamellaḥt",
            "aysum", "iselman", "ddhen"
    };

    private String[] photos = {
            "eten/eten_eieren.jpg", "eten/eten_olie.jpg",
            "eten/eten_koekjes.jpg", "eten/eten_thee.jpg",
            "eten/eten_koffie.jpg", "eten/eten_melk.jpg",
            "eten/eten_yoghurt.jpg", "eten/eten_water.jpg",
            "eten/eten_brood.jpg", "eten/eten_honing.jpg",
            "eten/eten_suiker.jpg", "eten/eten_zout.jpg",
            "eten/eten_vlees.jpg", "eten/eten_vissen.jpg",
            "eten/eten_boter.jpg",
    };

    private int[] audioFiles = {
            R.raw.eten_eieren, R.raw.eten_olie,
            R.raw.eten_koekjes, R.raw.eten_thee,
            R.raw.eten_koffie, R.raw.eten_melk,
            R.raw.eten_yoghurt, R.raw.eten_water,
            R.raw.eten_brood, R.raw.eten_honing,
            R.raw.eten_suiker, R.raw.eten_zout,
            R.raw.eten_vlees, R.raw.eten_vissen,
            R.raw.eten_boter
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
