package com.example.dennis.amazichquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpeelFruit extends AppCompatActivity {

    private String[] photos = {
            "fruit/fruit_appel.jpg", "fruit/fruit_peer.jpg",
            "fruit/fruit_abrikoos.jpg", "fruit/fruit_perzik.jpg",
            "fruit/fruit_druiven.jpg", "fruit/fruit_watermeloen.jpg",
            "fruit/fruit_honingmeloen.jpg", "fruit/fruit_granaatappel.jpg",
            "fruit/fruit_vijg.jpg","fruit/fruit_cactusvijg.jpg","fruit/fruit_pruim.jpg","fruit/fruit_sinaasappel.jpg",
            "fruit/fruit_dadel.jpg","fruit/fruit_citroen.jpg","fruit/fruit_bananen.jpg"


    };

    private String[] words = {
            "tateffaht","tafirast","rmecmac",
            "rxux","aḍil","ddellaɛ","abettix",
            "arremman","tazart","tahendict",
            "rbarquq","taleccint","tini",
            "llaymun","banan"
    };

    private int[] audioFiles = {
            R.raw.fruit_appel, R.raw.fruit_peer,
            R.raw.fruit_abrikoos, R.raw.fruit_perzik,
            R.raw.fruit_druiven, R.raw.fruit_watermeloen,
            R.raw.fruit_honingmeloen, R.raw.fruit_granaatappel,
            R.raw.fruit_vijg, R.raw.fruit_cactusvijg,
            R.raw.fruit_pruim, R.raw.fruit_sinaasappel,
            R.raw.fruit_dadel, R.raw.fruit_citroen,
            R.raw.fruit_bananen
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
    public void onBackPressed() {
        Intent i = new Intent(this,SpeelMenuActivity.class);
        startActivity(i);
    }
}
