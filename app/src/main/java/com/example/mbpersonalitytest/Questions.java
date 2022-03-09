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
        if (iterator < 10){
            I++;
        }
        if (iterator < 20 && iterator >= 10){
            N++;
        }
        if (iterator < 30 && iterator >= 20){
            T++;
        }
        if (iterator < 40 && iterator >= 30){
            J++;
        }
        iterator++;
        if (iterator == 41){
            Intent i = new Intent(this, Results.class);
            startActivity(i);
        }
    }

    public void onAgree(View stronglyAgree){
        TextView q = (TextView)findViewById(R.id.question);
        q.setText(questionsArray[iterator]);
        if (iterator < 10){
            I++;
        }
        if (iterator < 20 && iterator >= 10){
            N++;
        }
        if (iterator < 30 && iterator >= 20){
            T++;
        }
        if (iterator < 40 && iterator >= 30){
            J++;
        }
        iterator++;
        if (iterator == 41){
            Intent i = new Intent(this, Results.class);
            startActivity(i);
        }
    }

    public void onNotSure(View stronglyAgree){
        TextView q = (TextView)findViewById(R.id.question);
        q.setText(questionsArray[iterator]);
        if (iterator < 10){
            I++;
        }
        if (iterator < 20 && iterator >= 10){
            N++;
        }
        if (iterator < 30 && iterator >= 20){
            T++;
        }
        if (iterator < 40 && iterator >= 30){
            J++;
        }
        iterator++;
        if (iterator == 41){
            Intent i = new Intent(this, Results.class);
            startActivity(i);
        }
    }

    public void onDisagree(View stronglyAgree){
        TextView q = (TextView)findViewById(R.id.question);
        q.setText(questionsArray[iterator]);
        if (iterator < 10){
            I++;
        }
        if (iterator < 20 && iterator >= 10){
            N++;
        }
        if (iterator < 30 && iterator >= 20){
            T++;
        }
        if (iterator < 40 && iterator >= 30){
            J++;
        }
        iterator++;
        if (iterator == 41){
            Intent i = new Intent(this, Results.class);
            startActivity(i);
        }
    }

    public void onStronglyDisagree(View stronglyAgree){
        TextView q = (TextView)findViewById(R.id.question);
        q.setText(questionsArray[iterator]);
        if (iterator < 10){
            I++;
        }
        if (iterator < 20 && iterator >= 10){
            N++;
        }
        if (iterator < 30 && iterator >= 20){
            T++;
        }
        if (iterator < 40 && iterator >= 30){
            J++;
        }
        iterator++;
        if (iterator == 41){
            Intent i = new Intent(this, Results.class);
            startActivity(i);
        }
    }





/*
    public Questions(int type, String text, int qNumber){}


    Questions Q1 = new Questions(1, "Whats your name?", 1);
    Questions Q2 = new Questions(1, "Whats your name?", 2);
    Questions Q3 = new Questions(1, "Whats your name?", 3);
    Questions Q4 = new Questions(1, "Whats your name?", 4);
    Questions Q5 = new Questions(1, "Whats your name?", 5);
    Questions Q6 = new Questions(1, "Whats your name?", 6);
    Questions Q7 = new Questions(1, "Whats your name?", 7);
    Questions Q8 = new Questions(1, "Whats your name?", 8);
    Questions Q9 = new Questions(1, "Whats your name?", 9);
    Questions Q10 = new Questions(1, "Whats your name?", 10);
    Questions Q11 = new Questions(2, "Whats your name?", 11);
    Questions Q12 = new Questions(2, "Whats your name?", 12);
    Questions Q13 = new Questions(2, "Whats your name?", 13);
    Questions Q14 = new Questions(2, "Whats your name?", 14);
    Questions Q15 = new Questions(2, "Whats your name?", 15);
    Questions Q16 = new Questions(2, "Whats your name?", 16);
    Questions Q17 = new Questions(2, "Whats your name?", 17);
    Questions Q18 = new Questions(2, "Whats your name?", 18);
    Questions Q19 = new Questions(2, "Whats your name?", 19);
    Questions Q20 = new Questions(2, "Whats your name?", 20);
    Questions Q21 = new Questions(3, "Whats your name?", 21);
    Questions Q22 = new Questions(3, "Whats your name?", 22);
    Questions Q23 = new Questions(3, "Whats your name?", 23);
    Questions Q24 = new Questions(3, "Whats your name?", 24);
    Questions Q25 = new Questions(3, "Whats your name?", 25);
    Questions Q26 = new Questions(3, "Whats your name?", 26);
    Questions Q27 = new Questions(3, "Whats your name?", 27);
    Questions Q28 = new Questions(3, "Whats your name?", 28);
    Questions Q29 = new Questions(3, "Whats your name?", 29);
    Questions Q30 = new Questions(3, "Whats your name?", 30);
    Questions Q31 = new Questions(4, "Whats your name?", 31);
    Questions Q32 = new Questions(4, "Whats your name?", 32);
    Questions Q33 = new Questions(4, "Whats your name?", 33);
    Questions Q34 = new Questions(4, "Whats your name?", 34);
    Questions Q35 = new Questions(4, "Whats your name?", 35);
    Questions Q36 = new Questions(4, "Whats your name?", 36);
    Questions Q37 = new Questions(4, "Whats your name?", 37);
    Questions Q38 = new Questions(4, "Whats your name?", 38);
    Questions Q39 = new Questions(4, "Whats your name?", 39);
    Questions Q40 = new Questions(4, "Whats your name?", 40);
    */
}