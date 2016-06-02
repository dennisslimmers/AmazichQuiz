package com.example.dennis.amazichquiz;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class SwipeListener extends AppCompatActivity {
    private String TAG = "DEBUG";
    public String[] itemArray;
    public int[] photoArray;
    public TextView tv;
    public ImageView iv;

    GestureDetector.SimpleOnGestureListener simpleOnGestureListener = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            String swipe = "";
            float sensitvity = 200;

            if ((e1.getX() - e2.getX()) > sensitvity) {
                swipe += "left";
            } else if ((e2.getX() - e1.getX()) > sensitvity) {
                swipe += "right";
            } else {
                swipe += "\n";
            }

            changeItem(swipe, itemArray, tv);

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    };

    GestureDetector gestureDetector = new GestureDetector(simpleOnGestureListener);

    public SwipeListener (String[] itemArray, int[] photoArray, TextView tv, ImageView iv) {
        this.itemArray = itemArray;
        this.photoArray = photoArray;
        this.tv = tv;
        this.iv = iv;

        this.setItem(0);
        this.setItemPhoto(0);
    }

    public void changeItem(String direction, String[] array, TextView item) {
        int currentAnimalIndex = findIndex(array, (String)item.getText());
        int newAnimalIndex = 0;

        switch (direction) {
            case "left":
                newAnimalIndex = currentAnimalIndex + 1;

                if (!checkNull(newAnimalIndex, array)) {
                    setItem(newAnimalIndex);
                    setItemPhoto(newAnimalIndex);
                }

                break;
            case "right":
                newAnimalIndex = currentAnimalIndex - 1;

                if (!checkNull(newAnimalIndex, array)){
                    setItem(newAnimalIndex);
                    setItemPhoto(newAnimalIndex);
                }

                break;
        }
    }

    public void setItem(int index) {
        tv.setText(itemArray[index]);
    }

    public void setItemPhoto (int index) {
        iv.setImageResource(photoArray[index]);
        Log.d(TAG, "hello");
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

    public boolean checkNull (int index, String[] array) {
        if (index >= array.length || index < 0)
            return true;
        else
            return false;
    }
}
