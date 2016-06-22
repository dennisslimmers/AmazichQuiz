package com.example.dennis.amazichquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpeelKleding extends AppCompatActivity {

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

    private String[] words = {
            "ssarwal", "amaryul", "camisita ",
            "aqabud","tisila","ihakusen",
            "tcaccict", "tablust", "farda",
            "tcinklat", "iwantisan", "tqacir",
            "taqmijjat", "ahewwak", "abyas"
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

    private Button[] buttonsArray;

    private TextView word;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;


    SpeelManager sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speel_dieren);
        word = (TextView) findViewById(R.id.textView3);

        buttonsArray = new Button[6];

        button1 = (Button) findViewById(R.id.photo1);
        button2 = (Button) findViewById(R.id.photo2);
        button3 = (Button) findViewById(R.id.photo3);
        button4 = (Button) findViewById(R.id.photo4);
        button5 = (Button) findViewById(R.id.photo5);
        button6 = (Button) findViewById(R.id.photo6);

        buttonsArray[0] = button1;
        buttonsArray[1] = button2;
        buttonsArray[2] = button3;
        buttonsArray[3] = button4;
        buttonsArray[4] = button5;
        buttonsArray[5] = button6;

        sp = new SpeelManager(words, photos, audioFiles, word, buttonsArray, this);
    }

    public void clickButton(View v) {
        sp.clickButton(v);
    }
}
