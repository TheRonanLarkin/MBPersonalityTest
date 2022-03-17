package com.example.mbpersonalitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent i = getIntent();
        char[] bannerResultArray = i.getCharArrayExtra("Result");
        String bannerResult = String.valueOf(bannerResultArray);
        String resultTabIE = i.getStringExtra("P1");
        String resultTabNS = i.getStringExtra("P2");
        String resultTabTF = i.getStringExtra("P3");
        String resultTabJP = i.getStringExtra("P4");

        TextView r0 = (TextView)findViewById(R.id.resultsToolbarText);
        r0.setText(bannerResult);

        TextView r1 = (TextView)findViewById(R.id.rTab1);
        r1.setText(String.format("%s %s%%", bannerResultArray[0], resultTabIE));

        TextView r2 = (TextView)findViewById(R.id.rTab2);
        r2.setText(String.format("%s %s%%", bannerResultArray[1], resultTabNS));

        TextView r3 = (TextView)findViewById(R.id.rTab3);
        r3.setText(String.format("%s %s%%", bannerResultArray[2], resultTabTF));

        TextView r4 = (TextView)findViewById(R.id.rTab4);
        r4.setText(String.format("%s %s%%", bannerResultArray[3], resultTabJP));

    }

    public void finish(View finishButton){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}