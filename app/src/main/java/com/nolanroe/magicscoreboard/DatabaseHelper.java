package com.nolanroe.magicscoreboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Danolanater on 10/9/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Player.db";
    public static final String TABLE_NAME = "match_history_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "opponent";
    public static final String COL_3 = "game_type";
    public static final String COL_4 = "match_score";
    public static final String COL_5 = "date";
    public static final String COL_6 = "result";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 5);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "OPPONENT TEXT, GAME_TYPE TEXT, MATCH_SCORE TEXT, DATE TEXT, RESULT TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String opponent, String gameType, String matchScore, String date, String result) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, opponent);
        contentValues.put(COL_3, gameType);
        contentValues.put(COL_4, matchScore);
        contentValues.put(COL_5, date);
        contentValues.put(COL_6, result);
        long data = db.insert(TABLE_NAME, null, contentValues);
        if(data == -1)
            return false;
        else
             return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
}