package com.example.adel.moviesapp.movieDetail;

import android.util.Log;

import com.example.adel.moviesapp.Models.TrailerResponseModel;
import com.example.adel.moviesapp.callbacks.NetworkResponse;
import com.example.adel.moviesapp.controllers.APIController;

/**
 * Created by adelmacook on 27/12/16.
 */

public class MovieDetailPresenter implements MovieDetailContract.MovieDetailPresenter {
    MovieDetailContract.MovieDetailView mView;

    public MovieDetailPresenter(MovieDetailContract.MovieDetailView mView) {
        this.mView = mView;
    }

    @Override
    public void fetchTrailer(final int movieId) {
        APIController.getInstance().getMovieTrailers(movieId, new NetworkResponse<TrailerResponseModel>() {
            @Override
            public void onResponse(TrailerResponseModel response) {
                Log.d("MYID", movieId + ""
                );
                mView.onTrailersFetched(response);
            }
        });
    }

    @Override
    public void fetchReviews(int movieId) {

    }

    @Override
    public void start() {

    }
}
