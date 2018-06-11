package com.neryfranco.masterygame.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProfessorDB extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "Professor";

    // Table columns
    public static final String _ID = "_id";
    public static final String TODO_SUBJECT = "subject";
    public static final String TODO_DESC = "description";
    // Database Information
    static final String DB_NAME = "iMastery.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TODO_SUBJECT + " TEXT NOT NULL, " + TODO_DESC + " TEXT);";

    public ProfessorDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}