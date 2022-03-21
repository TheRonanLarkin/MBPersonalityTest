package com.example.mbpersonalitytest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    private static final String RESULTS_TABLE = "resultsTable";
    private static final String COLUMN_RESULT = "result";

    //constructor required by class
    public Database(Context context) {
        super(context, RESULTS_TABLE, null, 1);
    }

    //creating database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + RESULTS_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_RESULT +" TEXT)";
        db.execSQL(createTable);
    }

    //onUpgrade required by class but not used
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //method to add result string to database
    public void addResult(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_RESULT, item);
        db.insert(RESULTS_TABLE, null, contentValues);
    }

   //method to retrieve all data saved to database line by line and assign to list
   public Cursor getResults(){
       SQLiteDatabase db = this.getWritableDatabase();
       String query = "SELECT * FROM " + RESULTS_TABLE;
       return db.rawQuery(query, null);
   }

   //method to delete table
    public void deleteResults(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + RESULTS_TABLE;
        db.execSQL(query);
    }
}
