package com.example.adel.moviesapp.allMovies;

import android.database.Cursor;

import com.example.adel.moviesapp.Models.MovieModel;
import com.example.adel.moviesapp.callbacks.NetworkResponse;
import com.example.adel.moviesapp.controllers.APIController;


public class MoviesPresenter implements MoviesContract.Presenter {

    MoviesContract.View mView;

    public MoviesPresenter(MoviesContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void fetchMovies(boolean shouldLoadFromDB) {
        if (shouldLoadFromDB) {
            Cursor c = managedQuery(students, null, null, null, "name");

        } else {
            APIController.getInstance().getAllMovies(new NetworkResponse<MovieModel>() {
                @Override
                public void onResponse(MovieModel response) {
                    mView.moviesFetched(response);
                }
            });
        }
    }

    @Override
    public void fetchTopRated() {
        APIController.getInstance().getTopRated(new NetworkResponse<MovieModel>() {
            @Override
            public void onResponse(MovieModel response) {
                mView.moviesFetched(response);
            }
        });
    }

    @Override
    public void fetchPopular() {
        APIController.getInstance().getPopularMovies(new NetworkResponse<MovieModel>() {
            @Override
            public void onResponse(MovieModel response) {
                mView.moviesFetched(response);
            }
        });
    }

    @Override
    public void start() {

    }
}
