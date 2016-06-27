package com.example.dennis.amazichquiz;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Random;

public class SpeelManager extends AppCompatActivity {
    String[] randomPhotoArray;
    String[] usedWords;
    String[] photos;
    String[] words;
    Button[] buttonsArray;
    String[] translations;
    String databaseString;
    String[] databaseArray;
    int[] audioFiles;
    int[] audio;
    String lockedActivity;
    String unlockedActivity;
    String word;
    File data;
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
        this.databaseArray = new String[9];

        this.am = c.getAssets();
        this.photos = photos;
        this.words = words;
        this.tv = textView;
        this.c = c;
        this.audio = audio;

        this.lockedActivity = "";
        this.unlockedActivity = "";

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

            for (int nn = 0; nn <= randomPhotoArray.length -1; nn++) {
                setItemPhoto(randomPhotoArray[nn], buttonsArray[nn]);
                buttonsArray[nn].setText(translations[nn]);
            }

            playAudio(0);

            usedWords[subjectCount] = word;
            subjectCount ++;
        } else {
            writeDatabase();

            try {
                if (lockedActivity.contains("false")) {
                    unlockedActivity = lockedActivity.replace("false", "true");
                    databaseString = databaseString.replace(lockedActivity, unlockedActivity);

                    FileOutputStream fos = new FileOutputStream(data);
                    OutputStreamWriter osr = new OutputStreamWriter(fos);

                    osr.append(databaseString);

                    osr.close();
                    fos.close();
                }


            } catch (Exception e) {
                Log.d("Exception", e.getMessage());
            }

            SpeelDieren.redirect(c);
        }
    }

    public void writeDatabase () {
        try {
            String str = "";
            data = new File(Environment.getExternalStorageDirectory().getPath() + "/database.txt");
            BufferedReader reader = new BufferedReader(new FileReader(data));

            databaseString = "";
            int index = 0;
            while ((str = reader.readLine()) != null) {
                databaseString += str;
                databaseString += "\n";

                databaseArray[index] = str;

                index++;
            }

            String currentActivity =  c.getClass().getName().replace("com.example.dennis.amazichquiz.", "");
            String fullActivityName = currentActivity;
            currentActivity = currentActivity.replace("Speel", "");
            currentActivity = Character.toLowerCase(currentActivity.charAt(0)) +
                                                   (currentActivity.length() > 1 ? currentActivity.substring(1) : "");

            if (fullActivityName.equals("SpeelDieren")) {
                currentActivity += "1";
            }

            if (fullActivityName.equals("SpeelDierenTwee")) {
                currentActivity += "2";
            }

            for (int ii = 0; ii <= databaseArray.length; ii++) {
                boolean contains = databaseArray[ii].contains(currentActivity);

                if (contains) {
                    if (ii + 1 <= databaseArray.length) {
                        this.lockedActivity = databaseArray[ii + 1];
                    }
                }
            }
        } catch (Exception e) {
            Log.d("Exception", e.getMessage());
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
        String text = (String) btn.getText();

        if (text.equals(this.word)) {
            this.randomize();
			failure = 0;
        } else {
            btn.setBackgroundResource(0);
            btn.setBackgroundColor(Color.RED);

            failure++;
            Log.d("debug",""+failure);

            if (failure == 30) {
				SpeelDieren.redirect(c);
            }
        }
    }
}
