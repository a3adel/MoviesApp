package com.example.adel.moviesapp.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.Nullable;

import static com.example.adel.moviesapp.data.DataContract.BASE_CONTENT_URI;
import static java.security.AccessController.getContext;

/**
 * Created by Ahmed Adel on 1/25/2017.
 */

public class MoviesContentProvider extends ContentProvider {
    private static final int MOIVE_LIST = 1;
    private static final int MOVIE_ID = 2;
    private static final UriMatcher URI_MATCHER;
    SQLiteDatabase db;
    static{
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(DataContract.AUTHORITY, "movies", MOIVE_LIST);
        URI_MATCHER.addURI(DataContract.AUTHORITY, "movies/#", MOVIE_ID);
    }
    @Override
    public boolean onCreate() {
        Context context = getContext();
        MovieDBHelper dbHelper = new MovieDBHelper(context);

        /**
         * Create a write able database which will trigger its
         * creation if it doesn't already exist.
         */

        db = dbHelper.getWritableDatabase();
        return (db == null)? false:true;    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(DataContract.Movies.TABLE_NAME);
        Cursor retCursor;

        switch (URI_MATCHER.match(uri)) {
            case MOIVE_LIST:
                retCursor = db.query(
                        DataContract.Movies.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            case MOVIE_ID:
                long _id = ContentUris.parseId(uri);
                retCursor = db.query(
                        DataContract.Movies.TABLE_NAME,
                        projection,
                        DataContract.CommonColumns._ID + " = ?",
                        new String[]{String.valueOf(_id)},
                        null,
                        null,
                        sortOrder
                );
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);

        }

        if (sortOrder == null || sortOrder == ""){
            /**
             * By default sort on student names
             */
            sortOrder = DataContract.CommonColumns.NAME;
        }

        Cursor c = qb.query(db,	projection,	selection,
                selectionArgs,null, null, sortOrder);
        /**
         * register to watch a content URI for changes
         */
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {

        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        /**
         * Add a new movie record
         */
        long rowID = db.insert(	DataContract.Movies.TABLE_NAME
                , "", values);

        /**
         * If record is added successfully
         */
        if (rowID > 0) {
            Uri _uri = ContentUris.withAppendedId(BASE_CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }

        throw new SQLException("Failed to add a record into " + uri);

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Because null could delete all rows:
        int rows; // Number of rows effected

        switch(URI_MATCHER.match(uri)){

            case MOIVE_LIST:
                rows = db.delete(DataContract.Movies.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }


        if(selection == null || rows != 0){
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return rows;

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int rows;

        switch(URI_MATCHER.match(uri)){

            case MOIVE_LIST:
                rows = db.update(DataContract.Movies.TABLE_NAME, values, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        if(rows != 0){
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return rows;

    }
}