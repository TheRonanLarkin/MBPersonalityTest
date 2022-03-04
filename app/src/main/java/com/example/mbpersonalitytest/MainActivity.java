package com.example.mbpersonalitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTest(View startButton){
        Intent i = new Intent(this, Questions.class);
        startActivity(i);
    }

    public void viewHistory(View historyButton){
        Intent i = new Intent(this, History.class);
        startActivity(i);
    }
}