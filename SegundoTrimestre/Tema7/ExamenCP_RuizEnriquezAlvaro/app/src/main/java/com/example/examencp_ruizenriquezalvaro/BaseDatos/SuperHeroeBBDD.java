package com.example.examencp_ruizenriquezalvaro.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SuperHeroeBBDD extends SQLiteOpenHelper {

    String sqlCreate ="CREATE TABLE SuperHeroes(_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, telefono TEXT, avatar TEXT)";

    public SuperHeroeBBDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Clientes");
        sqLiteDatabase.execSQL(sqlCreate);
    }
}
