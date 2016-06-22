package com.example.dennis.amazichquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpeelKleuren extends AppCompatActivity {

    private String[] photos = {
            "kleuren/kleuren_rood.jpg", "kleuren/kleuren_geel.jpg",
            "kleuren/kleuren_blauw.jpg", "kleuren/kleuren_zwart.jpg",
            "kleuren/kleuren_wit.jpg", "kleuren/kleuren_bruin.jpg",
            "kleuren/kleuren_groen.jpg", "kleuren/kleuren_oranje.jpg",
            "kleuren/kleuren_bont.jpg", "kleuren/kleuren_paars.jpg"
    };

    private String[] words = {
            "azegg-aɣ", "awraɣ", "aḥmaymi",
            "abarcan","acemlal","ahemruni",
            "aziza", "aletcini", "akarkac",
            "azbaybi"
    };

    private int[] audioFiles = {
            R.raw.kleuren_rood, R.raw.kleuren_geel,
            R.raw.kleuren_blauw, R.raw.kleuren_zwart,
            R.raw.kleuren_wit, R.raw.kleuren_bruin,
            R.raw.kleuren_groen, R.raw.kleuren_oranje,
            R.raw.kleuren_bont, R.raw.kleuren_paars
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
