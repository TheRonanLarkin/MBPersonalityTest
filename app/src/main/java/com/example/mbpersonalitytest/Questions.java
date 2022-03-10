package com.example.mbpersonalitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Questions extends AppCompatActivity {

    public int I = 0;
    public int N = 0;
    public int T = 0;
    public int J = 0;
    public int E = 0;
    public int S = 0;
    public int F = 0;
    public int P = 0;

    public char[] results = new char[4];

    public double resultsPercent1 = 0;
    public double resultsPercent2 = 0;
    public double resultsPercent3 = 0;
    public double resultsPercent4 = 0;

    public int intResult1 = 0;
    public int intResult2 = 0;
    public int intResult3 = 0;
    public int intResult4 = 0;

    public int iterator = 1;
    String[] questionsArray = {"Q1", "Q2", "Q3", "Q4", "Q5", "Q6", "Q7", "Q8", "Q9", "Q10", "Q11", "Q12", "Q13", "Q14", "Q15", "Q16", "Q17", "Q18", "Q19", "Q20", "Q21", "Q22", "Q23", "Q24", "Q25", "Q26", "Q27", "Q28", "Q29", "Q30", "Q31", "Q32", "Q33", "Q34", "Q35", "Q36", "Q37", "Q38", "Q39", "Q40", " "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality_test);

        TextView q = (TextView)findViewById(R.id.question);
        q.setText(questionsArray[0]);

    }

    public void onStronglyAgree(View stronglyAgree){

        TextView q = (TextView)findViewById(R.id.question);
        q.setText(questionsArray[iterator]);

        if (iterator < 11){
            I = I + 2;
        }
        if (iterator < 21 && iterator > 10){
            N = N + 2;
        }
        if (iterator < 31 && iterator > 20){
            T = T + 2;
        }
        if (iterator < 41 && iterator > 30){
            J = J + 2;
        }

        iterator++;

        if (iterator == 41){
            tabulate();
        }
    }

    public void onAgree(View stronglyAgree){

        TextView q = (TextView)findViewById(R.id.question);
        q.setText(questionsArray[iterator]);

        if (iterator < 11){
            I++;
        }
        if (iterator < 21 && iterator > 10){
            N++;
        }
        if (iterator < 31 && iterator > 20){
            T++;
        }
        if (iterator < 41 && iterator > 30){
            J++;
        }

        iterator++;

        if (iterator == 41){
            tabulate();
        }
    }

    public void onNotSure(View stronglyAgree){

        TextView q = (TextView)findViewById(R.id.question);
        q.setText(questionsArray[iterator]);

        iterator++;

        if (iterator == 41){
            tabulate();
        }
    }

    public void onDisagree(View stronglyAgree){

        TextView q = (TextView)findViewById(R.id.question);
        q.setText(questionsArray[iterator]);

        if (iterator < 11){
            E++;
        }
        if (iterator < 21 && iterator > 10){
            S++;
        }
        if (iterator < 31 && iterator > 20){
            F++;
        }
        if (iterator < 41 && iterator > 30){
            P++;
        }

        iterator++;

        if (iterator == 41){
            tabulate();
        }
    }

    public void onStronglyDisagree(View stronglyAgree) {

        TextView q = (TextView) findViewById(R.id.question);
        q.setText(questionsArray[iterator]);

        if (iterator < 11) {
            E = E + 2;
        }
        if (iterator < 21 && iterator > 10) {
            S = S + 2;
        }
        if (iterator < 31 && iterator > 20) {
            F = F + 2;
        }
        if (iterator < 41 && iterator > 30) {
            P = P + 2;
        }

        iterator++;

        if (iterator == 41) {
            tabulate();
        }
    }

    public void tabulate(){

        calculateIE();
        calculateJP();
        calculateNS();
        calculateTF();

        Intent i = new Intent(this, Results.class);
        i.putExtra("Result", results);
        i.putExtra("P1", Integer.toString(intResult1));
        i.putExtra("P2", Integer.toString(intResult2));
        i.putExtra("P3", Integer.toString(intResult3));
        i.putExtra("P4", Integer.toString(intResult4));

        startActivity(i);
    }

    public void calculateIE(){
        if (I > E){
            resultsPercent1 =  ((I - E)/40.00) * 100;
            intResult1 = (int) resultsPercent1 + 50;
            results[0] = 'I';
        }
        if (E > I){
            resultsPercent1 =  ((E - I)/40.00) * 100;
            intResult1 = (int) resultsPercent1 + 50;
            results[0] = 'E';
        }
        if (I == E){
            resultsPercent1 = 50;
            intResult1 = (int) resultsPercent1;
            results[0] = 'I';
        }
    }

    public void calculateNS(){
        if (N > S){
            resultsPercent2 =  ((N - S)/40.00) * 100;
            intResult2 = (int) resultsPercent2 + 50;
            results[1] = 'N';
        }
        if (S > N){
            resultsPercent2 =  ((S - N)/40.00) * 100;
            intResult2 = (int) resultsPercent2 + 50;
            results[1] = 'S';
        }
        if (N == S){
            resultsPercent2 = 50;
            intResult2 = (int) resultsPercent2;
            results[1] = 'N';
        }
    }

    public void calculateTF() {
        if (T > F) {
            resultsPercent3 = ((T - F)/40.00) * 100;
            intResult3 = (int) resultsPercent3 + 50;
            results[2] = 'T';
        }
        if (F > T) {
            resultsPercent3 = ((F - T)/40.00) * 100;
            intResult3 = (int) resultsPercent3 + 50;
            results[2] = 'F';
        }
        if (T == F){
            resultsPercent3 = 50;
            intResult3 = (int) resultsPercent3;
            results[2] = 'T';
        }
    }

    public void calculateJP(){
        if (J > P){
            resultsPercent4 =  ((J - P)/40.00) * 100;
            intResult4 = (int) resultsPercent4 + 50;
            results[3] = 'J';
        }
        if (P > J){
            resultsPercent4 =  ((P - J)/40.00) * 100;
            intResult4 = (int) resultsPercent4 + 50;
            results[3] = 'P';
        }
        if (J == P){
            resultsPercent4 = 50;
            intResult4 = (int) resultsPercent4;
            results[3] = 'J';
        }
    }
}