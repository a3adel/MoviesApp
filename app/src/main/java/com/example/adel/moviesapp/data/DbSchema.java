package com.example.adel.moviesapp.data;

/**
 * Created by Ahmed Adel on 1/25/2017.
 */

public class DbSchema {
    public final static String DB_NAME = "MOVIES_DB";
    public final static String MOVIES_TABLE="movies";
    public final static String DDL_CREATE_TBL_MOVIE =
            "CREATE TABLE "+MOVIES_TABLE+" (" +
                    "_id           INTEGER  PRIMARY KEY AUTOINCREMENT, \n" +
                    "movie_name     TEXT,\n" +
                    "desc      TEXT,\n" +
                    "rate      REAL,\n" +
                    "isFavorite      INTEGER" +
                    ")";
    ;



}
