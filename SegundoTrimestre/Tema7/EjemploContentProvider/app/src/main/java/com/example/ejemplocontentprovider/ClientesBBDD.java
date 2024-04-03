package com.example.ejemplocontentprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ClientesBBDD extends SQLiteOpenHelper {

    String sqlCreate ="CREATE TABLE Clientes(_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, telefono TEXT, email TEXT)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        //
        db.execSQL(sqlCreate);

        // Por simplicidad del ejemplo, insertamos directamente clientes
        for(int i=1; i<10; i++){
            String nombre = "Cliente " + i;
            String telefono = "900-123-00" + i;
            String email = "email" + i + "gmail.com";

            // Insertamos los datos en la tabla cliente
            ContentValues registro = new ContentValues();
            registro.put("nombre",nombre);
            registro.put("telefono",telefono);
            registro.put("email",email);
            db.insert("Clientes",null,registro);

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Clientes");
        db.execSQL(sqlCreate);
    }

    public ClientesBBDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


}
