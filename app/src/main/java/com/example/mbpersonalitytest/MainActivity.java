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

    //methods to give functionality to start test and test history buttons
    public void startTest(View startButton){
        Intent i = new Intent(this, Questions.class);
        startActivity(i);
    }

    public void viewHistory(View historyButton){

        Intent i = new Intent(this, History.class);
        startActivity(i);
    }

    //makes sure back button exits app when pressed
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}