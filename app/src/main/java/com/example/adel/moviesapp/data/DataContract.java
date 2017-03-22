package com.example.adel.moviesapp.data;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Maiam on 3/20/2017.
 */

public class DataContract {
    /**
     * THE AUTHORITY OF THIS CONTRACT
     */
    public static final String AUTHORITY = "com.example.adel.moviesapp.data.MoviesContentProvider";
    /**
     * the content uri of the authority
     **/
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    /**
     * A selection clause for ID based queries.
     */
    public static final String SELECTION_ID_BASED = BaseColumns._ID + " = ? ";
    public static final String PATH_MOVIE = "movie";

    /**
     * Constants for the Movies table of the lentitems provider.
     */
    public static final class Movies implements BaseColumns {
        // Content URI represents the base location for the table
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_MOVIE).build();

        // These are special type prefixes that specify if a URI returns a list or a specific item
        public static final String CONTENT_TYPE =
                "vnd.android.cursor.dir/" + CONTENT_URI + "/" + PATH_MOVIE;
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/" + CONTENT_URI + "/" + PATH_MOVIE;

        // Define the table schema
        public static final String TABLE_NAME = "movies";
        public static final String COLUMN_NAME = "movie_name";
        public static final String COLUMN_RELEASE_DATE = "movieReleaseDate";

        // Define a function to build a URI to find a specific movie by it's identifier
        public static Uri buildMovieUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    public interface CommonColumns extends BaseColumns {
        String NAME = Movies.COLUMN_NAME;
        String RATE = "_rate";
        String RELEASE_DATE = Movies.COLUMN_RELEASE_DATE;
    }
}
