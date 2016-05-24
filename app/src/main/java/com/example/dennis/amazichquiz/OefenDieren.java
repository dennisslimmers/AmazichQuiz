package com.example.dennis.amazichquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class OefenDieren extends AppCompatActivity {
    private String TAG = "DEBUG";
    private String[] animals = {"Dog", "Cat", "Horse", "Tiger", "Lion", "Bird", "Fish"};
    TextView animal;

    GestureDetector.SimpleOnGestureListener simpleOnGestureListener = new GestureDetector.SimpleOnGestureListener(){
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            String swipe = "";
            float sensitvity = 50;

            if ((e1.getX() - e2.getX()) > sensitvity) {
                swipe += "left";
            } else if ((e2.getX() - e1.getX()) > sensitvity) {
                swipe += "right";
            } else {
                swipe += "\n";
            }

            changeAnimal(swipe);
//            Log.d(TAG, swipe);

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    };

    GestureDetector gestureDetector = new GestureDetector(simpleOnGestureListener);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oefen_dieren);

        animal = (TextView) findViewById(R.id.textView);
        setAnimal(0);
    }

    public void changeAnimal(String direction) {
        int currentAnimalIndex = findIndex(animals, (String)animal.getText());
        int newAnimalIndex = 0;

        switch (direction) {
            case "left":
                newAnimalIndex = currentAnimalIndex + 1;

                if (!checkNull(newAnimalIndex))
                    setAnimal(newAnimalIndex);

                break;
            case "right":
                newAnimalIndex = currentAnimalIndex - 1;

                if (!checkNull(newAnimalIndex))
                    setAnimal(newAnimalIndex);

                break;
        }
    }

    public int findIndex(String[] animals, String animal) {
        int index = -1;

        for (int ii = 0; ii < animals.length; ii++) {
            if (animals[ii].equals(animal)) {
                index = ii;
            }
        }

        return index;
    }

    public boolean checkNull (int index) {
        if (index >= animals.length || index < 0)
            return true;
        else
            return false;
    }

    public void setAnimal(int index) {
        animal.setText(animals[index]);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}
