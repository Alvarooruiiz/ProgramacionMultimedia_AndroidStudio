package com.example.ejemplocontentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.stream.BaseStream;

public class ClientesProvider extends ContentProvider {
    private static final String AUTHORITY = "com.example.ejemplocontentprovider";
    private static final String URI = "content://" + AUTHORITY + "/clientes";
    public static final Uri CONTENT_URI = Uri.parse(URI);

    // Definimos el objeto UriMatcher
    private static final int CLIENTES = 1; // Acceso generico a tabla
    private static final int CLIENTES_ID = 2; // Acceso a una fila (acceso a clientes por ID)
    public static final UriMatcher URI_MATCHER; // Objeto UriMatcher

    // Base de datos
    public ClientesBBDD clidb;
    public static final String BD_NOMBRE = "DBCLIENTES";
    public static final int BD_VERSION = 1;
    public static final String TABLA_CLIENTES = "Clientes";

    // Inicializamos el UriMatcher
    static{
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(AUTHORITY,"clientes", CLIENTES);
        URI_MATCHER.addURI(AUTHORITY,"clientes/#", CLIENTES_ID);
    }

    @Override
    public boolean onCreate() {
        clidb = new ClientesBBDD(getContext(),BD_NOMBRE,null,BD_VERSION);
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        // Si es una consulta a un ID concreto construimos el WHERE
        String where = selection;
        if(URI_MATCHER.match(uri) == CLIENTES_ID){
            where = "_id=" + uri.getLastPathSegment();
        }
        SQLiteDatabase db = clidb.getWritableDatabase();

        Cursor c = db.query(TABLA_CLIENTES,projection,where,selectionArgs,null,null,sortOrder);

        return c;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        int match = URI_MATCHER.match(uri);
        switch (match){
            case CLIENTES:
                return "vnd.android.cursor.dir/vnd.example.ejemplocontentprovider";

            case CLIENTES_ID:
                return "vnd.android.cursor.item/vnd.example.ejemplocontentprovider";
        }

        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        long regId;
        SQLiteDatabase db = clidb.getWritableDatabase();

        regId = db.insert(TABLA_CLIENTES,null,contentValues);

        Uri newUri = ContentUris.withAppendedId(CONTENT_URI,regId);

        return newUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        int cont;

        // Si es una consulta a un id concreto construimos el where
        String where = s;
        if(URI_MATCHER.match(uri) == CLIENTES_ID) {
            where = "_id" + uri.getLastPathSegment();
        }
            SQLiteDatabase db = clidb.getWritableDatabase();

            cont = db.delete(TABLA_CLIENTES,where,strings);

        return cont;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        int cont;

        // Si es una consulta a un id concreto construimos el where
        String where = s;
        if(URI_MATCHER.match(uri) == CLIENTES_ID) {
            where = "_id" + uri.getLastPathSegment();
        }
        SQLiteDatabase db = clidb.getWritableDatabase();

        cont = db.update(TABLA_CLIENTES,contentValues,where,strings);

        return cont;
    }

    public ClientesProvider(){}

    // Clase interna para declarar las constantes de columna
    public static final class Clientes implements BaseColumns{
        private Clientes(){}

        // Nombre de columnas
        public static final String COL_NOMBRE = "nombre";
        public static final String COL_TELEFONO = "telefono";
        public static final String COL_EMAIL = "email";




    }
}
