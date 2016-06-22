package com.example.dennis.amazichquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpeelDierenTwee extends AppCompatActivity {

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

    private String[] words = {
            "Adbir", "Aḥamchel ", "Ayaṛziz",
            "Ifis","Tata","Asekkur",
            "Icfar", "Tɣirdent", "Afiɣra",
            "Aruy", "Muka", "Icɛb",
            "Ilf", "Uccay", "Tiflillest"
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
