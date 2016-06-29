package com.example.dennis.amazichquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpeelEten extends AppCompatActivity {

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

    private String[] words = {
            "timejjalin", "zzict", "ɣayiṭa",
            "atay","rqehwa","aɣi",
            "accil", "aman", "aɣrum",
            "tamment", "sseqqur", "tamellaḥt",
            "aysum", "iselman", "ddhen"
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
