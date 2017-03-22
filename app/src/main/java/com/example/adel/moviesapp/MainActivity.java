package com.example.adel.moviesapp;

import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.adel.moviesapp.allMovies.AllMoviesInteractorImp;
import com.example.adel.moviesapp.allMovies.MoviesContract;
import com.example.adel.moviesapp.allMovies.MoviesFragment;
import com.example.adel.moviesapp.allMovies.MoviesPresenter;
import com.example.adel.moviesapp.callbacks.NetworkResponse;
import com.example.adel.moviesapp.controllers.APIController;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!checkForNetwork()) {
            AlertDialog.Builder alerBuilder = new AlertDialog.Builder(this);
            alerBuilder.setMessage(getString(R.string.check_your_network)).setTitle(R.string.network_alert_title);
            AlertDialog alertDialog = alerBuilder.create();
            alertDialog.show();
        } else {
            MoviesFragment moviesFragment = new MoviesFragment();
            MoviesContract.Interactor interactor=new AllMoviesInteractorImp(this);
            MoviesPresenter moviesPresenter = new MoviesPresenter(moviesFragment,interactor);
            moviesFragment.setPresenter(moviesPresenter);
            getFragmentManager().beginTransaction().add(R.id.activity_main, moviesFragment).commit();
        }
    }

    boolean checkForNetwork() {
        MyApplication myApplication = (MyApplication) getApplication();
        return myApplication.isOnline();
    }
}
