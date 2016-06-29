package com.example.dennis.amazichquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpeelInsecten extends AppCompatActivity {

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

    private String[] words = {
            "aɣlal", "adan n tmurt", "takecca",
            "iẓi","zizwit","nnamus",
            "tikedfet", "aferṭṭu", "qundɣa ",
            "burxes", "bugḍif", "yaẓẓa",
            "buccel ", "tiḍḍa", "tamraebt"
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
