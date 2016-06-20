package com.example.dennis.amazichquiz;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class OefenDierenTwee extends AppCompatActivity {
    private String[] words = {
            "Duif", "Gekko", "Haas",
            "Hyena","Kameleon","Patrijs",
            "Schildpad", "Schorpioen", "Slang",
            "Stekelvarken", "Uil", "Vos",
            "Wilfzwijn", "Windhond", "Zwaluw"
    };

    private String[] translations = { //todo deze nog vertalen.
            "Adbir", "Aḥamchel ", "Ayaṛziz",
            "Ifis","Tata","Asekkur",
            "Icfar", "Tɣirdent", "Afiɣra",
            "Aruy", "Muka", "Icɛb",
            "Ilf", "Uccay", "Tiflillest"
    };

    private String[] photos = {
            "dieren2/dieren02_duif.jpg", "dieren2/dieren02_gekko.jpg",
            "dieren2/dieren02_haas.jpg", "dieren2/dieren02_hyena.jpg",
            "dieren2/dieren02_kameleon.jpg", "dieren2/dieren02_patrijs.jpg",
            "dieren2/dieren02_schildpad.jpg", "dieren2/dieren02_schorpioen.jpg",
            "dieren2/dieren02_slang.jpg", "dieren2/dieren02_stekelvarken.jpg",
            "dieren2/dieren02_uil.jpg", "dieren2/dieren02_vos.jpg",
            "dieren2/dieren02_wildzwijn.jpg", "dieren2/dieren02_windhond.jpg",
            "dieren2/dieren02_zwaluw.jpg",
    };

    private int[] audioFiles = { 
            R.raw.dieren02_duif, R.raw.dieren02_gekko,
            R.raw.dieren02_haas, R.raw.dieren02_hyena,
            R.raw.dieren02_kameleon, R.raw.dieren02_patrijs,
            R.raw.dieren02_schildpad, R.raw.dieren02_schorpioen,
            R.raw.dieren02_slang, R.raw.dieren02_stekelvarken,
            R.raw.dieren02_uil, R.raw.dieren02_vos,
            R.raw.dieren02_wildzwijn, R.raw.dieren02_windhond,
            R.raw.dieren02_zwaluw
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
