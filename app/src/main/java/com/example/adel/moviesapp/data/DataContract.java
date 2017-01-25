package com.example.adel.moviesapp.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;
import android.provider.ContactsContract;

/**
 * Created by Ahmed Adel on 1/25/2017.
 */

public final class DataContract {
    /**
     * THE AUTHORITY OF THIS CONTRACT
     */
    public static final String AUTHORITY = "data.moviesapp.movieItems";
    /**
     * the content uri of the authority
     **/
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    /**
     * A selection clause for ID based queries.
     */
    public static final String SELECTION_ID_BASED = BaseColumns._ID + " = ? ";

    /**
     * Constants for the Movies table of the lentitems provider.
     */
    public static final class Movies implements CommonColumns {
        /**
         * The content URI for this table.
         */
        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(
                        ContactsContract.Data.CONTENT_URI,
                        "movies");

        /**
         * The mime type of a single item.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE +
                        "/vnd.data.moviesapp.movieItems_items";

        /**
         * A projection of all columns
         * in the items table.
         */
        public static final String[] PROJECTION_ALL =
                {_ID, NAME, RATE};

        /**
         * The default sort order for
         * queries containing NAME fields.
         */
        public static final String SORT_ORDER_DEFAULT =
                NAME + " ASC";
    }

    public interface CommonColumns extends BaseColumns {
        String NAME = "_name";
        String RATE = "_rate";
    }
}
