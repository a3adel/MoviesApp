package com.example.adel.moviesapp.data.repositories;

import android.content.SharedPreferences;

/**
 * Created by Ahmed Adel on 1/31/2017.
 */

public class InMemoryDataSavedRepository implements SavedDataRepository {
    SharedPreferences sharedPreferences;
    private final String IS_DATA_SAVED="isDataSaved";
    public InMemoryDataSavedRepository(SharedPreferences sharedPreferences){
        this.sharedPreferences=sharedPreferences;
    }
    @Override
    public void saveFlag() {
        sharedPreferences.edit().putBoolean(IS_DATA_SAVED,true).apply();
    }

    @Override
    public boolean isDataSaved() {
        return sharedPreferences.getBoolean(IS_DATA_SAVED,false);
    }
}
