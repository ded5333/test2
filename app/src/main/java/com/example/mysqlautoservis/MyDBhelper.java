package com.example.mysqlautoservis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBhelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE Cars (idCar INTEGER PRIMARY KEY AUTOINCREMENT, markamodel TEXT, crash TEXT, priceCrash INTEGER)";

    private static final String SQL_CREATE_ENTRIES_WORKER =
            "CREATE TABLE Worker (idWorker INTEGER PRIMARY KEY AUTOINCREMENT , name TEXT, skill TEXT, age INTEGER , carId INTEGER) ";

    public MyDBhelper(@Nullable Context context) {
        super(context, "DataBase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        db.execSQL(SQL_CREATE_ENTRIES_WORKER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
