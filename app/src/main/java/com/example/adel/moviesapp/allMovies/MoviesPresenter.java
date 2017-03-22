package com.example.adel.moviesapp.allMovies;

import android.database.Cursor;

import com.example.adel.moviesapp.Models.MovieModel;
import com.example.adel.moviesapp.callbacks.NetworkResponse;
import com.example.adel.moviesapp.controllers.APIController;


public class MoviesPresenter implements MoviesContract.Presenter {

    MoviesContract.View mView;
    MoviesContract.Interactor interactor;

    public MoviesPresenter(MoviesContract.View mView, MoviesContract.Interactor interactor) {
        this.mView = mView;
        this.interactor=interactor;
    }

    @Override
    public void fetchMovies(boolean shouldLoadFromDB) {
        if (shouldLoadFromDB) {
            interactor.fetchMoviesFromDB();
        } else {
            APIController.getInstance().getAllMovies(new NetworkResponse<MovieModel>() {
                @Override
                public void onResponse(MovieModel response) {
                    mView.moviesFetched(response);
                    interactor.saveMovies(
                            response
                    );
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
