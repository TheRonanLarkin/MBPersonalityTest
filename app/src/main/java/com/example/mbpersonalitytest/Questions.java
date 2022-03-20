package com.example.mbpersonalitytest;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Questions extends AppCompatActivity {

    //variables to track points given to each letter in result
    public int I = 0;
    public int N = 0;
    public int T = 0;
    public int J = 0;
    public int E = 0;
    public int S = 0;
    public int F = 0;
    public int P = 0;

    //storing result as size 4 character array
    public char[] result = new char[4];

    //storing points scored as a percentage to display on results page
    public double resultsPercentIE = 0;
    public double resultsPercentNS = 0;
    public double resultsPercentTF = 0;
    public double resultsPercentJP = 0;

    //casting percentage to integer for display on results page
    public int resultIE = 0;
    public int resultNS = 0;
    public int resultTF = 0;
    public int resultJP = 0;

    //iterator to keep track of which question the user is on
    public int iterator = 1;

    //array of questions to be filled from questions stored in xml resources
    String[] questionsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality_test);

        //reading xml questions array into questionsArray and setting as text view
        questionsArray = getResources().getStringArray(R.array.question_array);
        TextView firstQ = (TextView)findViewById(R.id.question);
        firstQ.setText(questionsArray[0]);
    }

    //method to handle back button functionality
    public void finish(View finishButton){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    //all buttons either add or subtract points from each letter depending on context of question
    //questions are ordered I N T J E S F P and therefore mod 8 is used
    public void onStronglyAgree(View stronglyAgree){

        TextView nextQ = (TextView)findViewById(R.id.question);
        nextQ.setText(questionsArray[iterator]);

        if (iterator % 8 == 1){
            I = I + 2;
        }
        if (iterator % 8 == 2){
            N = N + 2;
        }
        if (iterator % 8 == 3){
            T = T + 2;
        }
        if (iterator % 8 == 4){
            J = J + 2;
        }
        if (iterator % 8 == 5){
            E = E + 2;
        }
        if (iterator % 8 == 6){
            S = S + 2;
        }
        if (iterator % 8 == 7){
            F = F + 2;
        }
        if (iterator % 8 == 0){
            P = P + 2;
        }

        iterator++;

        //when iterator reaches 41, tabulate method is called and quiz ends
        if (iterator == 41){
            tabulate();
        }
    }



    public void onAgree(View stronglyAgree){

        TextView nextQ = (TextView)findViewById(R.id.question);
        nextQ.setText(questionsArray[iterator]);

        if (iterator % 8 == 1){
            I++;
        }
        if (iterator % 8 == 2){
            N++;
        }
        if (iterator % 8 == 3){
            T++;
        }
        if (iterator % 8 == 4){
            J++;
        }
        if (iterator % 8 == 5){
            E++;
        }
        if (iterator % 8 == 6){
            S++;
        }
        if (iterator % 8 == 7){
            F++;
        }
        if (iterator % 8 == 0){
            P++;
        }

        iterator++;

        if (iterator == 41){
            tabulate();
        }
    }

    public void onNotSure(View stronglyAgree){

        TextView nextQ = (TextView)findViewById(R.id.question);
        nextQ.setText(questionsArray[iterator]);

        iterator++;

        if (iterator == 41){
            tabulate();
        }
    }

    public void onDisagree(View stronglyAgree){

        TextView nextQ = (TextView)findViewById(R.id.question);
        nextQ.setText(questionsArray[iterator]);

        if (iterator % 8 == 1){
            I = I - 1;
        }
        if (iterator % 8 == 2){
            N = N - 1;
        }
        if (iterator % 8 == 3){
            T = T - 1;
        }
        if (iterator % 8 == 4){
            J = J - 1;
        }
        if (iterator % 8 == 5){
            E = E - 1;
        }
        if (iterator % 8 == 6){
            S = S - 1;
        }
        if (iterator % 8 == 7){
            F = F - 1;
        }
        if (iterator % 8 == 0){
            P = P - 1;
        }

        iterator++;

        if (iterator == 41){
            tabulate();
        }
    }

    public void onStronglyDisagree(View stronglyAgree) {

        TextView nextQ = (TextView) findViewById(R.id.question);
        nextQ.setText(questionsArray[iterator]);

        if (iterator % 8 == 1){
            I = I - 2;
        }
        if (iterator % 8 == 2){
            N = N - 2;
        }
        if (iterator % 8 == 3){
            T = T - 2;
        }
        if (iterator % 8 == 4){
            J = J - 2;
        }
        if (iterator % 8 == 5){
            E = E - 2;
        }
        if (iterator % 8 == 6){
            S = S - 2;
        }
        if (iterator % 8 == 7){
            F = F - 2;
        }
        if (iterator % 8 == 0){
            P = P - 2;
        }

        iterator++;

        if (iterator == 41){
            tabulate();
        }
    }

    //tabulate method calculates which of each letter is to be added to result
    public void tabulate(){

        calculateIE();
        calculateNS();
        calculateTF();
        calculateJP();

        //all relevant result information is passed to the results page with putExtra
        Intent i = new Intent(this, Results.class);
        i.putExtra("result", result);
        i.putExtra("P1", Integer.toString(resultIE));
        i.putExtra("P2", Integer.toString(resultNS));
        i.putExtra("P3", Integer.toString(resultTF));
        i.putExtra("P4", Integer.toString(resultJP));

        startActivity(i);
    }

    //four methods each deciding values for result and results percentage
    public void calculateIE(){
        if (I > E){
            resultsPercentIE =  ((I - E)/40.00) * 100;
            resultIE = (int) resultsPercentIE + 50;
            result[0] = 'I';
        }
        if (E > I){
            resultsPercentIE =  ((E - I)/40.00) * 100;
            resultIE = (int) resultsPercentIE + 50;
            result[0] = 'E';
        }
        if (I == E){
            resultsPercentIE = 50;
            resultIE = (int) resultsPercentIE;
            result[0] = 'I';
        }
    }

    public void calculateNS(){
        if (N > S){
            resultsPercentNS =  ((N - S)/40.00) * 100;
            resultNS = (int) resultsPercentNS + 50;
            result[1] = 'N';
        }
        if (S > N){
            resultsPercentNS =  ((S - N)/40.00) * 100;
            resultNS = (int) resultsPercentNS + 50;
            result[1] = 'S';
        }
        if (N == S){
            resultsPercentNS = 50;
            resultNS = (int) resultsPercentNS;
            result[1] = 'N';
        }
    }

    public void calculateTF() {
        if (T > F) {
            resultsPercentTF = ((T - F)/40.00) * 100;
            resultTF = (int) resultsPercentTF + 50;
            result[2] = 'T';
        }
        if (F > T) {
            resultsPercentTF = ((F - T)/40.00) * 100;
            resultTF = (int) resultsPercentTF + 50;
            result[2] = 'F';
        }
        if (T == F){
            resultsPercentTF = 50;
            resultTF = (int) resultsPercentTF;
            result[2] = 'T';
        }
    }

    public void calculateJP(){
        if (J > P){
            resultsPercentJP =  ((J - P)/40.00) * 100;
            resultJP = (int) resultsPercentJP + 50;
            result[3] = 'J';
        }
        if (P > J){
            resultsPercentJP =  ((P - J)/40.00) * 100;
            resultJP = (int) resultsPercentJP + 50;
            result[3] = 'P';
        }
        if (J == P){
            resultsPercentJP = 50;
            resultJP = (int) resultsPercentJP;
            result[3] = 'J';
        }
    }

}