package com.example.adel.moviesapp.movieDetail;

import com.example.adel.moviesapp.BasePresenter;
import com.example.adel.moviesapp.BaseView;

/**
 * Created by adelmacook on 27/12/16.
 */

public class MovieDetailContract {
    interface MovieDetailView extends BaseView<MovieDetailPresenter> {
    }

    interface MovieDetailPresenter extends BasePresenter {

    }
}
