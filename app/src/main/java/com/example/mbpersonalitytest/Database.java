package com.example.mbpersonalitytest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

//class extend implement SQLiteOpenHelper and define database operations
public class Database extends SQLiteOpenHelper {

    public static final String COLUMN_RESULT = "RESULT";
    public static final String RESULTS_TABLE = COLUMN_RESULT + "S_TABLE";
    public static final String COLUMN_DATE = "DATE";
    public static final String COLUMN_ID = "ID";

    public Database(@Nullable Context context) {
        super(context, "results.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + RESULTS_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_RESULT + " TEXT, " + COLUMN_DATE + " TEXT)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //method to write value to database
    public void addResult(ResultsModel resultsModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_RESULT, resultsModel.getResult());
        cv.put(COLUMN_DATE, resultsModel.getDate());

        long insert = db.insert(RESULTS_TABLE, null, cv);

    }


   //method to retrieve all data saved to database line by line and assign to list
   public ArrayList<ResultsModel> readResults() {

       SQLiteDatabase db = this.getReadableDatabase();

       Cursor cursor = db.rawQuery("SELECT * FROM " + RESULTS_TABLE, null);

       ArrayList<ResultsModel> resultsArrayList = new ArrayList<>();

       if (cursor.moveToFirst()) {
           do {

               resultsArrayList.add(new ResultsModel(cursor.getInt(1), cursor.getString(2), cursor.getString(3)));

           } while (cursor.moveToNext());
       }

       db.close();
       cursor.close();
       return resultsArrayList;
   }
}
