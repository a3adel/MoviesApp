package com.example.adel.moviesapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ahmed Adel on 1/25/2017.
 */

public class MovieDBHelper extends SQLiteOpenHelper {
    private static final String NAME = DbSchema.DB_NAME;
    private static final int VERSION = 1;
    public MovieDBHelper(Context context){
        super(context, NAME, null, VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbSchema.DDL_CREATE_TBL_MOVIE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +  DbSchema.DDL_CREATE_TBL_MOVIE);

    }
}
