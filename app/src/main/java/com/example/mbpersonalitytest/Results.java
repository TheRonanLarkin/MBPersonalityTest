package com.example.mbpersonalitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        int type = 0;

        //reading in relevant info from questions class with getExtra
        Intent i = getIntent();
        char[] bannerResultArray = i.getCharArrayExtra("result");
        String bannerResult = String.valueOf(bannerResultArray);
        String resultTabIE = i.getStringExtra("P1");
        String resultTabNS = i.getStringExtra("P2");
        String resultTabTF = i.getStringExtra("P3");
        String resultTabJP = i.getStringExtra("P4");

        //setting the banner to four letter result as string and adding individual letters and percentages to display tab
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

        type = returnResultType(bannerResultArray);
        resultText = returnResultText(type);
        TextView firstQ = (TextView)findViewById(R.id.rText);
        firstQ.setText(resultText);

        //assigning formatted date of test completion to string variable
        Date currentDate = Calendar.getInstance().getTime();
        String formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentDate);

        ResultsModel resultsModel;

        try {
            resultsModel = new ResultsModel(-1, bannerResult, formattedDate);
            Toast.makeText(Results.this, resultsModel.toString(), Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(Results.this, "Error Saving Result", Toast.LENGTH_SHORT).show();
            resultsModel = new ResultsModel(-1, "Error", "Error");
        }

        Database database = new Database(Results.this);
        database.addResult(resultsModel);
        Toast.makeText(Results.this, "Result Saved Successfully", Toast.LENGTH_SHORT).show();

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