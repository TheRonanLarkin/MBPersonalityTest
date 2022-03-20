package com.example.mbpersonalitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class History extends AppCompatActivity {

    ListView resultsList = findViewById(R.id.resultsList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Database database = new Database(History.this);
        List<ResultsModel> results = database.readResults();

        //Toast.makeText(History.this, results.toString(), Toast.LENGTH_SHORT).show();

        //ArrayAdapter resultArrayAdapter = new ArrayAdapter(History.this, android.R.layout.simple_list_item_1);
        //resultsList.setAdapter(resultArrayAdapter);

    }

    //method to handle back button functionality
    public void finish(View finishButton){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}