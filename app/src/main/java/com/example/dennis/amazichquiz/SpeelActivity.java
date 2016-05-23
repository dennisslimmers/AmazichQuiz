package com.example.dennis.amazichquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SpeelActivity extends AppCompatActivity {
    private String TAG = "DEBUG";
    public Button dieren1;
    public Button fruit;
    public Button insecten;
    public Button groente;
    public Button dieren2;
    public Button eten;
    public Button kleding;
    public Button kleur;
    public Button weer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speel);
        dieren1 = (Button) findViewById(R.id.button4);
        fruit = (Button) findViewById(R.id.button5);
        insecten = (Button) findViewById(R.id.button6);
        groente = (Button) findViewById(R.id.button7);
        dieren2 = (Button) findViewById(R.id.button8);
        eten = (Button) findViewById(R.id.button9);
        kleding = (Button) findViewById(R.id.button10);
        kleur = (Button) findViewById(R.id.button11);
        weer = (Button) findViewById(R.id.button12);

        try {
            readDatabase();
        } catch (IOException e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public void readDatabase() throws IOException {
        String str = "";
        InputStream is = this.getResources().openRawResource(R.raw.data);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        while ((str = reader.readLine()) != null) {
            // fetch boolean
            int dashPosition = str.indexOf("-");
            boolean unlocked = Boolean.parseBoolean(str.substring(dashPosition + 1));

            Log.d(TAG, unlocked ? "true" : "false");
        }

        is.close();
    }
}
