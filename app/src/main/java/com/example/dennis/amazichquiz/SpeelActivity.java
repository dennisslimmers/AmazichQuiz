package com.example.dennis.amazichquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SpeelActivity extends AppCompatActivity {
    private String TAG = "DEBUG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speel);

        try {
            readDatabase();
        } catch (IOException e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public void readDatabase() throws IOException {
        String str = "";
        StringBuffer buf = new StringBuffer();
        InputStream is = this.getResources().openRawResource(R.raw.database);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        while ((str = reader.readLine()) != null) {
            Log.d(TAG, str);
        }

        is.close();
    }
}
