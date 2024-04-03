package com.example.actividad9;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class MiContentProvider extends ContentProvider {

    // Definición de la autoridad del proveedor de contenido
    private static final String AUTORIDAD = "com.example.micontentprovider";
    // Definición del nombre de la tabla
    private static final String NOMBRE_TABLA = "versiones";
    // Definición de la URI base del proveedor de contenido
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTORIDAD + "/" + NOMBRE_TABLA);

    // Definición de los códigos de la URI
    private static final int TODAS_LAS_VERSIONES = 1;
    private static final int UNA_VERSION = 2;

    private static final UriMatcher uriMatcher;

    // Inicialización del UriMatcher
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTORIDAD, NOMBRE_TABLA, TODAS_LAS_VERSIONES);
        uriMatcher.addURI(AUTORIDAD, NOMBRE_TABLA + "/#", UNA_VERSION);
    }

    private MiOpenHelper openHelper;

    @Override
    public boolean onCreate() {
        openHelper = new MiOpenHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = openHelper.getWritableDatabase();
        Cursor cursor;

        switch (uriMatcher.match(uri)) {
            case TODAS_LAS_VERSIONES:
                cursor = db.query(NOMBRE_TABLA, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case UNA_VERSION:
                selection = "_id = ?";
                selectionArgs = new String[]{uri.getLastPathSegment()};
                cursor = db.query(NOMBRE_TABLA, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("URI desconocida: " + uri);
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case TODAS_LAS_VERSIONES:
                return "vnd.android.cursor.dir/vnd.com.example.micontentprovider." + NOMBRE_TABLA;
            case UNA_VERSION:
                return "vnd.android.cursor.item/vnd.com.example.micontentprovider." + NOMBRE_TABLA;
            default:
                throw new IllegalArgumentException("URI desconocida: " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = openHelper.getWritableDatabase();

        long rowId = db.insert(NOMBRE_TABLA, null, values);
        if (rowId > 0) {
            Uri rowUri = ContentUris.withAppendedId(CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(rowUri, null);
            return rowUri;
        }

        throw new SQLException("Falla al insertar fila en " + uri);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = openHelper.getWritableDatabase();

        int count;
        switch (uriMatcher.match(uri)) {
            case TODAS_LAS_VERSIONES:
                count = db.delete(NOMBRE_TABLA, selection, selectionArgs);
                break;
            case UNA_VERSION:
                String rowId = uri.getLastPathSegment();
                count = db.delete(NOMBRE_TABLA, "_id = ?", new String[]{rowId});
                break;
            default:
                throw new IllegalArgumentException("URI desconocida: " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = openHelper.getWritableDatabase();

        int count;
        switch (uriMatcher.match(uri)) {
            case TODAS_LAS_VERSIONES:
                count = db.update(NOMBRE_TABLA, values, selection, selectionArgs);
                break;
            case UNA_VERSION:
                String rowId = uri.getLastPathSegment();
                count = db.update(NOMBRE_TABLA, values, "_id = ?", new String[]{rowId});
                break;
            default:
                throw new IllegalArgumentException("URI desconocida: " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}