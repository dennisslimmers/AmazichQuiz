package com.example.dennis.amazichquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class OefenDieren extends AppCompatActivity {
    private String[] animals = {"Dog","Cat","Horse","Tiger","Lion","Bird","Fish"};

    private int[] animalPhotos = {
        R.drawable.dog,
        R.drawable.cat,
        R.drawable.horse,
        R.drawable.tiger,
        R.drawable.lion,
        R.drawable.bird,
        R.drawable.fish
    };

    TextView animal;
    ImageView animalPhoto;
    SwipeListener sl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oefen_dieren);

        animal = (TextView) findViewById(R.id.textView);
        animalPhoto = (ImageView) findViewById(R.id.animalView);

        sl = new SwipeListener(animals, animalPhotos, animal, animalPhoto);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return sl.gestureDetector.onTouchEvent(event);
    }
}
