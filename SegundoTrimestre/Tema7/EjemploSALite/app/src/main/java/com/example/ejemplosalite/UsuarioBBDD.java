package com.example.ejemplosalite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UsuarioBBDD extends SQLiteOpenHelper {

    // Setencia SQL para crear la tabla de usuarios
    String slqCreate = "CREATE TABLE Usuarios(codigo INTEGER  PRIMARY KEY, nombre TEXT)";

    public UsuarioBBDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Se ejecuta la sentencia SQL de creación de tabla
        db.execSQL(slqCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // NOTA: Por simplicidad del ejemplo vamos a borrar y volver a crear directamente
        //     las tablas para no tener que hacer copia de seguridad de la
        //     información y restablecerla

        // Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Usuarios");

        // Se crea la nueva versión
        db.execSQL(slqCreate);
    }
}
