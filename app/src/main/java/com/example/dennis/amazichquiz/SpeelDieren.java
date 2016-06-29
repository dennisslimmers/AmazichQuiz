package com.example.dennis.amazichquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpeelDieren extends AppCompatActivity {

    private String[] photos = {
        "dieren1/dieren01_egel.jpg", "dieren1/dieren01_ezel.jpg",
        "dieren1/dieren01_geit.jpg", "dieren1/dieren01_hond.jpg",
        "dieren1/dieren01_jakhals.jpg", "dieren1/dieren01_kat.jpg",
        "dieren1/dieren01_kikker.jpg", "dieren1/dieren01_kip.jpg",
        "dieren1/dieren01_koe.jpg", "dieren1/dieren01_konijn.jpg",
        "dieren1/dieren01_muis.jpg", "dieren1/dieren01_paard.jpg",
        "dieren1/dieren01_schaap.jpg", "dieren1/dieren01_vis.jpg",
        "dieren1/dieren01_vogel.jpg",
    };

    private String[] words = {
        "Insi", "Aɣyul", "Tɣaṭṭ",
        "Ayḍi","Uccen","Mucc",
        "Aqaqriw", "Tyaziḍt", "Tafunast",
        "Aqninni", "Aɣerda", "Ayis",
        "Icerri", "Aslem", "Agḍiḍ"
    };

    private int[] audioFiles = {
        R.raw.dieren01_egel, R.raw.dieren01_ezel,
        R.raw.dieren01_geit, R.raw.dieren01_hond,
        R.raw.dieren01_jakhals, R.raw.dieren01_kat,
        R.raw.dieren01_kikker, R.raw.dieren01_kip,
        R.raw.dieren01_koe, R.raw.dieren01_konijn,
        R.raw.dieren01_muis, R.raw.dieren01_paard,
        R.raw.dieren01_schaap, R.raw.dieren01_vis,
        R.raw.dieren01_vogel
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

    public static void redirect(Context c) {
        Intent i = new Intent(c,SpeelMenuActivity.class);
        c.startActivity(i);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this,SpeelMenuActivity.class);
        startActivity(i);
    }
}
