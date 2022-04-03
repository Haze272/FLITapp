package com.example.flitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);
        getSupportActionBar().hide();
    }
}
