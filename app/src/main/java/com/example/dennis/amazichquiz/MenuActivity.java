package com.example.dennis.amazichquiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_actvity);
    }

    public void RedirectOefen(View v) {
        Intent i = new Intent(this, OefenActivity.class);
        startActivity(i);
    }

    public void RedirectSpeel(View v) {
        Intent i = new Intent(this, SpeelActivity.class);
        startActivity(i);
    }

    public void RedirectOver(View v) {
        Intent i = new Intent(this, OverActivity.class);
        startActivity(i);
    }
}
