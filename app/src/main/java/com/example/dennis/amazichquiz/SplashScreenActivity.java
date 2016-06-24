package com.example.dennis.amazichquiz;

import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        createDatabase();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, MenuActivity.class);
                startActivity(i);
                finish();
            }
        }, 1000);
    }

    public void createDatabase() {
        try {
            File database = new File(Environment.getExternalStorageDirectory().getPath() + "/database.txt");

            if (!database.exists()) {
                boolean datatext = database.createNewFile();
                FileOutputStream fout = new FileOutputStream(database);
                OutputStreamWriter osw = new OutputStreamWriter(fout);
                osw.append("dieren1-true\n" +
                            "fruit-false\n" +
                            "insecten-false\n" +
                            "groenten-false\n" +
                            "dieren2-false\n" +
                            "eten-false\n" +
                            "kleding-false\n" +
                            "kleur-false\n" +
                            "weer-false");

                osw.close();
                fout.close();
            }
        } catch (Exception e) {
            Log.d("EXCEPTION", e.getMessage());
        }
    }
}
