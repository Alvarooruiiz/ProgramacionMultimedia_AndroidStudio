package com.example.examencp_ruizenriquezalvaro.BaseDatos;

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

import com.example.examencp_ruizenriquezalvaro.BaseDatos.SuperHeroeBBDD;

public class SuperHeroeProvider extends ContentProvider {
    private static final String AUTHORITY = "com.example.examencp_ruizenriquezalvaro";
    private static final String URI = "content://" + AUTHORITY + "/superheroes";
    public static final Uri CONTENT_URI = Uri.parse(URI);

    private static final int SUPERHEROES = 1;
    private static final int SUPERHEROES_ID = 2;
    public static final UriMatcher URI_MATCHER;

    // Base de datos
    public SuperHeroeBBDD shdb;
    public static final String BD_NOMBRE = "DBSUPERHEROE";
    public static final int BD_VERSION = 1;
    public static final String TABLA_SUPERHEROES = "SuperHeroes";

    static{
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(AUTHORITY,"superheroes", SUPERHEROES);
        URI_MATCHER.addURI(AUTHORITY,"superheroes/#", SUPERHEROES_ID);
    }

    @Override
    public boolean onCreate() {
        shdb = new SuperHeroeBBDD(getContext(),BD_NOMBRE,null,BD_VERSION);
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        // Si es una consulta a un ID concreto construimos el WHERE
        String where = s;
        if(URI_MATCHER.match(uri) == SUPERHEROES_ID){
            where = "_id=" + uri.getLastPathSegment();
        }
        SQLiteDatabase db = shdb.getWritableDatabase();

        Cursor c = db.query(TABLA_SUPERHEROES,strings,where,strings1,null,null,s1);

        return c;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        int match = URI_MATCHER.match(uri);
        switch (match){
            case SUPERHEROES:
                return "vnd.android.cursor.dir/vnd.example.examencp_ruizenriquezalvaro";

            case SUPERHEROES_ID:
                return "vnd.android.cursor.item/vnd.example.examencp_ruizenriquezalvaro";
        }

        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        long regId;
        SQLiteDatabase db = shdb.getWritableDatabase();

        regId = db.insert(TABLA_SUPERHEROES,null,contentValues);

        Uri newUri = ContentUris.withAppendedId(CONTENT_URI,regId);

        return newUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        int cont;

        String where = s;
        if(URI_MATCHER.match(uri) == SUPERHEROES_ID) {
            where = "_id" + uri.getLastPathSegment();
        }
        SQLiteDatabase db = shdb.getWritableDatabase();

        cont = db.delete(TABLA_SUPERHEROES,where,strings);

        return cont;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        int cont;

        String where = s;
        if(URI_MATCHER.match(uri) == SUPERHEROES_ID) {
            where = "_id" + uri.getLastPathSegment();
        }
        SQLiteDatabase db = shdb.getWritableDatabase();

        cont = db.update(TABLA_SUPERHEROES,contentValues,where,strings);

        return cont;
    }

    public SuperHeroeProvider(){}

    public static final class SuperHeroes implements BaseColumns {
        private SuperHeroes(){}

        public static final String COL_NOMBRE = "nombre";
        public static final String COL_TELEFONO = "telefono";
        public static final String COL_AVATAR = "avatar";




    }
}
