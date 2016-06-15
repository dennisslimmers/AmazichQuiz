package com.example.dennis.amazichquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SpeelDieren extends AppCompatActivity {

    private int[] animalPhotos = {

    };

    ImageView photo1;
    ImageView photo2;
    ImageView photo3;
    ImageView photo4;
    ImageView photo5;
    ImageView photo6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speel_dieren);

        photo1 = (ImageView) findViewById(R.id.imageView);
        photo2 = (ImageView) findViewById(R.id.imageView2);
        photo3 = (ImageView) findViewById(R.id.imageView3);
        photo4 = (ImageView) findViewById(R.id.imageView4);
        photo5 = (ImageView) findViewById(R.id.imageView5);
        photo6 = (ImageView) findViewById(R.id.imageView6);
    }
}
