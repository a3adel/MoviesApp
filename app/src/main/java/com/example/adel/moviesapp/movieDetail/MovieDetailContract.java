package com.example.adel.moviesapp.movieDetail;

import com.example.adel.moviesapp.BasePresenter;
import com.example.adel.moviesapp.BaseView;
import com.example.adel.moviesapp.Models.TrailerResponseModel;

/**
 * Created by adelmacook on 27/12/16.
 */

public class MovieDetailContract {
    interface MovieDetailView extends BaseView<MovieDetailPresenter> {
        void onTrailersFetched(TrailerResponseModel trailerResponseModel);
        void isDataSaved(boolean isDataSaved);
    }

    interface MovieDetailPresenter extends BasePresenter {
        void fetchTrailer(int movieId);
        void fetchReviews(int movieId);
    }
}
