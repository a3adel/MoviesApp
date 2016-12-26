package com.example.adel.moviesapp;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.example.adel.moviesapp.allMovies.MoviesFragment;
import com.example.adel.moviesapp.allMovies.MoviesPresenter;
import com.example.adel.moviesapp.callbacks.NetworkResponse;
import com.example.adel.moviesapp.controllers.APIController;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MoviesFragment moviesFragment=new MoviesFragment();
        MoviesPresenter moviesPresenter=new MoviesPresenter(moviesFragment);
        moviesFragment.setPresenter(moviesPresenter);
        getFragmentManager().beginTransaction().add(R.id.activity_main,moviesFragment).commit();
    }
}
