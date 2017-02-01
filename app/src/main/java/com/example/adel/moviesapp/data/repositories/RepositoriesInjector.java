package com.example.adel.moviesapp.data.repositories;

import android.content.Context;

/**
 * Created by Ahmed Adel on 1/31/2017.
 */
import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class RepositoriesInjector {
    public static InMemoryDataSavedRepository inMemoryDataSavedRepository(Context context){
        return new InMemoryDataSavedRepository(getDefaultSharedPreferences(context));
    }

}
