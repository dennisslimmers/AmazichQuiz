package com.example.dennis.amazichquiz;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class SwipeListener extends AppCompatActivity {
    private String TAG = "DEBUG";
    public String[] itemArray;
    public String[] translationsArray;
    public String[] photoArray;
    public int[] audioArray;
    public AssetManager am;
    public TextView tv;
    public TextView tvv;
    public ImageView iv;
    public Context c;

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

    public SwipeListener (String[] itemArray, String[] translationsArray, String[] photoArray, int[] audioArray, TextView tv, TextView tvv,  ImageView iv, Context c) {
        this.am = c.getAssets();
        this.itemArray = itemArray;
        this.photoArray = photoArray;
        this.tv = tv;
        this.iv = iv;
        this.tvv = tvv;
        this.translationsArray = translationsArray;
        this.audioArray = audioArray;
        this.c = c;

        this.setItem(0);
        this.setItemPhoto(photoArray, 0);
        this.setTranslation(0);
        this.playAudio(0);
    }

    public void changeItem(String direction, String[] array, TextView item) {
        int currentAnimalIndex = findIndex(array, (String)item.getText());
        int newAnimalIndex = 0;

        switch (direction) {
            case "left":
                newAnimalIndex = currentAnimalIndex + 1;

                if (!checkNull(newAnimalIndex, array)) {
                    setItem(newAnimalIndex);
                    setTranslation(newAnimalIndex);
                    setItemPhoto(photoArray, newAnimalIndex);
                    playAudio(newAnimalIndex);
                }

                break;
            case "right":
                newAnimalIndex = currentAnimalIndex - 1;

                if (!checkNull(newAnimalIndex, array)){
                    setItem(newAnimalIndex);
                    setTranslation(newAnimalIndex);
                    setItemPhoto(photoArray, newAnimalIndex);
                    playAudio(newAnimalIndex);
                }

                break;
        }
    }

    public void setItem(int index) {
        tv.setText(itemArray[index]);
    }

    public void setTranslation(int index) {
        tvv.setText(translationsArray[index]);
    }

    public void playAudio(int index) {
        MediaPlayer m = MediaPlayer.create(c, audioArray[index]);
        m.start();
    }

    public void setItemPhoto (String[] photosArray, int index) {
        InputStream i;

        try {
            i = am.open(photoArray[index]);
            Drawable d = Drawable.createFromStream(i, null);
            iv.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
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

    public boolean checkNull (int index, String[] array) {
        if (index >= array.length || index < 0)
            return true;
        else
            return false;
    }
}
