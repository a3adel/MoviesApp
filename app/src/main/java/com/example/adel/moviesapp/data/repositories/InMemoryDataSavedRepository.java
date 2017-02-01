package com.example.adel.moviesapp.data.repositories;

import android.content.SharedPreferences;

/**
 * Created by Ahmed Adel on 1/31/2017.
 */

public class InMemoryDataSavedRepository implements SavedDataRepository {
    SharedPreferences sharedPreferences;
    public InMemoryDataSavedRepository(SharedPreferences sharedPreferences){
        this.sharedPreferences=sharedPreferences;
    }
    @Override
    public void saveFlag() {

    }

    @Override
    public void isDataSaved(boolean isDataSaved) {

    }
}
