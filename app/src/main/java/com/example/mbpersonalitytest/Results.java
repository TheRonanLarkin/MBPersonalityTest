package com.example.mbpersonalitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Results extends AppCompatActivity {

    //string to hold description text for whichever personality type is returned
    String resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //variable to keep track of which of 16 types result matches with
        int type;

        //reading in relevant info from questions class with getExtra
        Intent i = getIntent();
        char[] bannerResultArray = i.getCharArrayExtra("result");
        String bannerResult = String.valueOf(bannerResultArray);
        String resultTabIE = i.getStringExtra("P1");
        String resultTabNS = i.getStringExtra("P2");
        String resultTabTF = i.getStringExtra("P3");
        String resultTabJP = i.getStringExtra("P4");

        //setting the banner to four letter result as string
        TextView r0 = (TextView)findViewById(R.id.resultsToolbarText);
        r0.setText(bannerResult);
        //adding individual letters and percentages to display tabs
        TextView tIE = (TextView)findViewById(R.id.rTab1);
        tIE.setText(String.format("%s %s%%", bannerResultArray[0], resultTabIE));
        TextView tNS = (TextView)findViewById(R.id.rTab2);
        tNS.setText(String.format("%s %s%%", bannerResultArray[1], resultTabNS));
        TextView tTF = (TextView)findViewById(R.id.rTab3);
        tTF.setText(String.format("%s %s%%", bannerResultArray[2], resultTabTF));
        TextView tJP = (TextView)findViewById(R.id.rTab4);
        tJP.setText(String.format("%s %s%%", bannerResultArray[3], resultTabJP));

        //determining personality type to assign appropriate text string
        type = returnResultType(bannerResultArray);
        resultText = returnResultText(type);
        TextView firstQ = (TextView)findViewById(R.id.rText);
        firstQ.setText(resultText);

        //assigning formatted date of test completion to string variable and concatenating with result string
        Date currentDate = Calendar.getInstance().getTime();
        String formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentDate);
        String resultDisplayString = ("Result: " + bannerResult + "\n" + formattedDate);

        //adding result string to database
        Database database = new Database(Results.this);
        database.addResult(resultDisplayString);
        //Toast.makeText(Results.this, resultDisplayString, Toast.LENGTH_SHORT).show();

    }

    //giving functionality to back button
    public void finish(View finishButton){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    //overriding functionality of phone back button to stop user from returning to quiz page
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    //method to decide which result description is returned based on its assigned integer value
    public String returnResultText(int type){

        String text = "test";

        if (type == 1){
            text = getString(R.string.intj);
        }
        if (type == 2){
            text = getString(R.string.intp);
        }
        if (type == 3){
            text = getString(R.string.infj);
        }
        if (type == 4){
            text = getString(R.string.infp);
        }
        if (type == 5){
            text = getString(R.string.istj);
        }
        if (type == 6){
            text = getString(R.string.istp);
        }
        if (type == 7){
            text = getString(R.string.isfj);
        }
        if (type == 8){
            text = getString(R.string.isfp);
        }
        if (type == 9){
            text = getString(R.string.entj);
        }
        if (type == 10){
            text = getString(R.string.entp);
        }
        if (type == 11){
            text = getString(R.string.enfj);
        }
        if (type == 12){
            text = getString(R.string.enfp);
        }
        if (type == 13){
            text = getString(R.string.estj);
        }
        if (type == 14){
            text = getString(R.string.estp);
        }
        if (type == 15){
            text = getString(R.string.esfj);
        }
        if (type == 16){
            text = getString(R.string.esfp);
        }
        
        return text;
    }

    //finding which of 16 types the result is and returning it to above method
    public int returnResultType(char[] result){
        int type = 0;

        if (result[0] == 'I' && result[1] == 'N' && result[2] == 'T' && result[3] == 'J'){
            type = 1;
        }
        if (result[0] == 'I' && result[1] == 'N' && result[2] == 'T' && result[3] == 'P'){
            type = 2;
        }
        if (result[0] == 'I' && result[1] == 'N' && result[2] == 'F' && result[3] == 'J'){
            type = 3;
        }
        if (result[0] == 'I' && result[1] == 'N' && result[2] == 'F' && result[3] == 'P'){
            type = 4;
        }
        if (result[0] == 'I' && result[1] == 'S' && result[2] == 'T' && result[3] == 'J'){
            type = 5;
        }
        if (result[0] == 'I' && result[1] == 'S' && result[2] == 'T' && result[3] == 'P'){
            type = 6;
        }
        if (result[0] == 'I' && result[1] == 'S' && result[2] == 'F' && result[3] == 'J'){
            type = 7;
        }
        if (result[0] == 'I' && result[1] == 'S' && result[2] == 'F' && result[3] == 'P'){
            type = 8;
        }
        if (result[0] == 'E' && result[1] == 'N' && result[2] == 'T' && result[3] == 'J'){
            type = 9;
        }
        if (result[0] == 'E' && result[1] == 'N' && result[2] == 'T' && result[3] == 'P'){
            type = 10;
        }
        if (result[0] == 'E' && result[1] == 'N' && result[2] == 'F' && result[3] == 'J'){
            type = 11;
        }
        if (result[0] == 'E' && result[1] == 'N' && result[2] == 'F' && result[3] == 'P'){
            type = 12;
        }
        if (result[0] == 'E' && result[1] == 'S' && result[2] == 'T' && result[3] == 'J'){
            type = 13;
        }
        if (result[0] == 'E' && result[1] == 'S' && result[2] == 'T' && result[3] == 'P'){
            type = 14;
        }
        if (result[0] == 'E' && result[1] == 'S' && result[2] == 'F' && result[3] == 'J'){
            type = 15;
        }
        if (result[0] == 'E' && result[1] == 'S' && result[2] == 'F' && result[3] == 'P'){
            type = 16;
        }

        return type;
    }
}