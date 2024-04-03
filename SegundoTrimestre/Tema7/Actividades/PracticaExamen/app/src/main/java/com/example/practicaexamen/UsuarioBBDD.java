package com.example.practicaexamen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UsuarioBBDD extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Usuarios(codigo INTEGER PRIMARY KEY, nombre TEXT, telef TEXT, avatar INTEGER)";

    public UsuarioBBDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USUARIOS");
        sqLiteDatabase.execSQL(sqlCreate);
    }
}
