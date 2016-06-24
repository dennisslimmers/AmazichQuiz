package com.example.dennis.amazichquiz;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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
    String[] words;
    Button[] buttonsArray;
    String[] translations;
    int[] audioFiles;
    int[] audio;
    String word;
    TextView tv;
    int failure = 0;
    int index;
    int subjectCount;
    String subject;
    AssetManager am;
    Context c;

    public SpeelManager(String[] words, String[] photos, int[] audio, TextView textView, Button[] buttonsArray, Context c) {
        this.buttonsArray = buttonsArray;
        this.translations = new String[6];
        this.audioFiles = new int[6];

        this.am = c.getAssets();
        this.photos = photos;
        this.words = words;
        this.tv = textView;
        this.c = c;
        this.audio = audio;

        randomPhotoArray = new String[6];
        usedWords = new String[words.length];

        subjectCount = 0;

        randomize();
    }

    public void randomize() {
        if (subjectCount < words.length -1) {
            Log.d("DEBUG", "subject count: "+subjectCount);

            this.word = randomWord(words);

            while (Arrays.asList(usedWords).contains(this.word)) {
                this.word = randomWord(words);
            }

            this.setWord(tv,this.word);
            randomPhotoArray[0] = photos[index];

            for (int ii = 1; ii <= randomPhotoArray.length -1; ii++) {
                String randPhoto = photos[randomizeIndex(14)];

                if (!Arrays.asList(randomPhotoArray).contains(randPhoto)) {
                    randomPhotoArray[ii] = randPhoto;
                } else {
                    ii--;
                }
            }

            setTranslations();

            setAudioFiles();

            ShuffleArray(buttonsArray);

            for (int i = 0; i <= randomPhotoArray.length -1; i++) {
                setItemPhoto(randomPhotoArray[i], buttonsArray[i]);
                buttonsArray[i].setText(translations[i]);
            }

            playAudio(0);

            usedWords[subjectCount] = word;
            subjectCount ++;
        } else {
            SpeelDieren.redirect(c);
        }
    }

    public void setWord(TextView tv, String text) {
        tv.setText(text);
    }

    public String randomWord (String[] words) {
        subject = words[randomizeIndex(14)];

        return subject;
    }

    public int randomizeIndex(int num) {
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

    public void setTranslations() {
        for (int ii = 0; ii <= randomPhotoArray.length - 1; ii++) {
           int index = findIndex(photos, randomPhotoArray[ii]);

           this.translations[ii] = words[index];
        }
    }

    public void setAudioFiles() {
        for (int ii = 0; ii <= randomPhotoArray.length - 1; ii++) {
            int index = findIndex(photos, randomPhotoArray[ii]);

            this.audioFiles[ii] = audio[index];
        }
    }

    public void playAudio(int index) {
        MediaPlayer m = MediaPlayer.create(c, audioFiles[index]);
        m.start();
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


    public void ShuffleArray(Button[] array) {
        Button temp;
        int index;
        Random random = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public void clickButton (View v) {
        Button btn = (Button) v;
        String text = ""+btn.getText();
        Log.d("DEBUG", text);

        if (text.equals(this.word)) {
            this.randomize();
			failure = 0;
        } else {
            btn.setBackgroundResource(0);
            btn.setBackgroundColor(Color.RED);

            failure++;
            Log.d("debug",""+failure);

            if (failure == 3) {
				SpeelDieren.redirect(c);
            }
        }
    }
}
