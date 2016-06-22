package com.example.dennis.amazichquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpeelWeer extends AppCompatActivity {

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

    private String[] words = {
            "tafsut", "anebdu", "leiglief",
            "tajarst","anẓar","adfel",
            "asemmiḍ taslit n", "unzar", "yur",
            "tfuct", "taziri", "ajjaj",
            "itri", "tayyut", "asinu"
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
