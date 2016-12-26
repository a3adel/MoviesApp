package com.example.adel.moviesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.adel.moviesapp.callbacks.NetworkResponse;
import com.example.adel.moviesapp.controllers.APIController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        APIController.getInstance().getAllMovies(new NetworkResponse() {
            @Override
            public void onResponse(Object response) {
                Log.d("TAG","BLA");
            }
        });
    }
}
