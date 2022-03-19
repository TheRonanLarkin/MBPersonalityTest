package com.example.mbpersonalitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class History extends AppCompatActivity {

    String[] resultHistory = new String[5];
    String[] dateHistory = new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Intent i = getIntent();
        String[] resultText = i.getStringArrayExtra("RT");
        String[] resultDate = i.getStringArrayExtra("RD");
        int iterator = i.getIntExtra("I", 0);

        TextView r = (TextView)findViewById(R.id.textView);
        r.setText(resultText[iterator]);

        TextView r2 = (TextView)findViewById(R.id.textView2);
        r2.setText(resultDate[iterator]);

    }

    public void finish(View finishButton){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}