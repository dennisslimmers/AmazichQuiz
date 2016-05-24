package com.example.dennis.amazichquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class OefenDieren extends AppCompatActivity {
    private String TAG = "DEBUG";

    GestureDetector.SimpleOnGestureListener simpleOnGestureListener = new GestureDetector.SimpleOnGestureListener(){
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            String swipe = "";
            float sensitvity = 50;

            if ((e1.getX() - e2.getX()) > sensitvity) {
                swipe += "Swipe Left\n";
            } else if ((e2.getX() - e1.getX()) > sensitvity) {
                swipe += "Swipe Right\n";
            } else {
                swipe += "\n";
            }

            Log.d(TAG, swipe);

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    };

    GestureDetector gestureDetector = new GestureDetector(simpleOnGestureListener);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oefen_dieren);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}
