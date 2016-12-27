package com.example.adel.moviesapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.adel.moviesapp.Models.Results;
import com.example.adel.moviesapp.movieDetail.MovieDetailFragment;

public class MovieDetailActivity extends AppCompatActivity {
    public final static String MOVIE = "MOVIE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        Results movie = (Results) intent.getSerializableExtra(MOVIE);
        MovieDetailFragment movieFragment=new MovieDetailFragment();
        Bundle bundle=new Bundle();
        bundle.putSerializable(MOVIE,movie);
        movieFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().add(R.id.container,movieFragment).commit();


    }
}
