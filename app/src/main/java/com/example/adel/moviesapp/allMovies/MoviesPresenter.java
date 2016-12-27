package com.example.adel.moviesapp.allMovies;

import com.example.adel.moviesapp.Models.MovieModel;
import com.example.adel.moviesapp.callbacks.NetworkResponse;
import com.example.adel.moviesapp.controllers.APIController;


public class MoviesPresenter implements MoviesContract.Presenter {

    MoviesContract.View mView;

    public MoviesPresenter(MoviesContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void fetchMovies() {
        APIController.getInstance().getAllMovies(new NetworkResponse<MovieModel>() {
            @Override
            public void onResponse(MovieModel response) {
                mView.moviesFetched(response);
            }
        });
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
