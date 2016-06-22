package com.example.dennis.amazichquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpeelGroenten extends AppCompatActivity {

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

    private String[] words = {
            "rḥimez", "leɛdes", "llubeyyet",
            "ttumatic","zzitun","baṭaṭa",
            "rebser", "ticcart", "dra",
            "rferfer", "taxsact", "xizzu",
            "tinifin", "ibawen", "ṭebi"
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
