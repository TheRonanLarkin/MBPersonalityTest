package com.example.mbpersonalitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class History extends AppCompatActivity {

    private ListView resultsList;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        resultsList = (ListView) findViewById(R.id.resultsList);
        database = new Database(this);

        createResultList();

    }

    //method to handle back button functionality
    public void finish(View finishButton){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    //method to add results database to arraylist and display
    private void createResultList() {

        Cursor data = database.getResults();
        ArrayList<String> listData = new ArrayList<>();

        while (data.moveToNext()) {
            listData.add(data.getString(1));
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        resultsList.setAdapter(adapter);
    }
}