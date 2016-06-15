package com.example.dennis.amazichquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class SpeelDieren extends AppCompatActivity {

    private int[] animalPhotos = {R.drawable.dieren01_egel

    };

    Button photo1;
    Button photo2;
    Button photo3;
    Button photo4;
    Button photo5;
    Button photo6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speel_dieren);

        photo1 = (Button) findViewById(R.id.photo1);
        photo2 = (Button) findViewById(R.id.photo2);
        photo3 = (Button) findViewById(R.id.photo3);
        photo4 = (Button) findViewById(R.id.photo4);
        photo5 = (Button) findViewById(R.id.photo5);
        photo6 = (Button) findViewById(R.id.photo6);

        photo1.setBackgroundResource(animalPhotos[0]);
        photo2.setBackgroundResource(animalPhotos[0]);
        photo3.setBackgroundResource(animalPhotos[0]);
        photo4.setBackgroundResource(animalPhotos[0]);
        photo5.setBackgroundResource(animalPhotos[0]);
        photo6.setBackgroundResource(animalPhotos[0]);

    }
}
