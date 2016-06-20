package com.example.dennis.amazichquiz;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;

public class SpeelManager extends AppCompatActivity {
    String[] randomPhotoArray;
    String[] usedWords;
    String[] photos;
    String word;
    int index;
    int subjectCount;
    String subject;
    public AssetManager am;


    public SpeelManager(String[] words, String[] photos, int[] audioFiles, TextView textView, Button[] buttonsArray, Context c) {
        this.word = randomWord(words);

        this.setWord(textView,this.word);
        this.am = c.getAssets();
        this.photos = photos;

        randomPhotoArray = new String[6];
        usedWords = new String[15];

        this.subjectCount = 0;

        randomPhotoArray[0] = photos[index];
        setItemPhoto(randomPhotoArray[0], buttonsArray[0]);

        for (int ii = 1; ii <= randomPhotoArray.length -1; ii++) {
            String randPhoto = photos[randomizeIndex(14)];

            if (!Arrays.asList(randomPhotoArray).contains(randPhoto)) {
                randomPhotoArray[ii] = randPhoto;
            } else {
                ii--;
            }
        }

        for (int i = 1; i <= 5; i++) {
            setItemPhoto(randomPhotoArray[i], buttonsArray[i]);
        }
    }

    public void setWord(TextView tv, String text) {
        tv.setText(text);
    }

    public String randomWord (String[] words) {
        subject = words[randomizeIndex(14)];

        return subject;
    }

    public int randomizeIndex(int num){
        Random random = new Random();

        int rand = random.nextInt(num) + 0;
        this.index = rand;

        return rand;
    }

    public void setItemPhoto (String photo, Button b) {
        InputStream i;

        try {
            i = am.open(photo);
            Drawable d = Drawable.createFromStream(i, null);
            b.setBackground(d);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
