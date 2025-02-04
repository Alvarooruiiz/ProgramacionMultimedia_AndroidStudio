package com.example.exament7_13_02_ruizenriquezalvaro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CineBBDD extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Cine(codigo INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, foto INTEGER, lista INTEGER)";

    public CineBBDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP  TABLE IF EXISTS Cine");
        db.execSQL(sqlCreate);
    }
}
