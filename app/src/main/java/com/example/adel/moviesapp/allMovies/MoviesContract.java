package com.example.adel.moviesapp.allMovies;

import com.example.adel.moviesapp.BasePresenter;
import com.example.adel.moviesapp.BaseView;
import com.example.adel.moviesapp.Models.MovieModel;


public class MoviesContract {
    interface View extends BaseView<Presenter> {
        void moviesFetched(MovieModel movieModel);
    }

    interface Presenter extends BasePresenter {
        void fetchMovies(boolean shouldLoadFromDB);

        void fetchTopRated();

        void fetchPopular();
    }

    public interface Interactor {
        void fetchMoviesFromDB();

        void saveMovies(MovieModel movieModel);
    }
}
