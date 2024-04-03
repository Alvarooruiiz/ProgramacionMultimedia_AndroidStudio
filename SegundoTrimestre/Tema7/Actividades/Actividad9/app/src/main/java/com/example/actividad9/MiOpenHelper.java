package com.example.actividad9;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MiOpenHelper extends SQLiteOpenHelper {

    // Nombre de la base de datos
    private static final String NOMBRE_BASE_DE_DATOS = "mi_base_de_datos.db";
    // Versión de la base de datos
    private static final int VERSION_BASE_DE_DATOS = 1;

    // Sentencia SQL para crear la tabla
    private static final String SQL_CREAR_TABLA =
            "CREATE TABLE versiones (_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, anio INTEGER);";

    public MiOpenHelper(Context context) {
        super(context, NOMBRE_BASE_DE_DATOS, null, VERSION_BASE_DE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Se ejecuta cuando la base de datos se crea por primera vez
        db.execSQL(SQL_CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Se ejecuta cuando la versión de la base de datos cambia
        // Aquí puedes agregar código para migrar datos si es necesario
        db.execSQL("DROP TABLE IF EXISTS versiones");
        onCreate(db);
    }
}