package com.example.adel.moviesapp.data.repositories;

import android.content.Context;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

/**
 * Created by Ahmed Adel on 1/31/2017.
 */

public class RepositoriesInjector {
    public static InMemoryDataSavedRepository inMemoryDataSavedRepository(Context context) {
        return new InMemoryDataSavedRepository(getDefaultSharedPreferences(context));
    }

}
