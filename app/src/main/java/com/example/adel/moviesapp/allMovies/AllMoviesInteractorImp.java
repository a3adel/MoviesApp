package com.example.adel.moviesapp.allMovies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.example.adel.moviesapp.Models.MovieModel;
import com.example.adel.moviesapp.Models.Results;
import com.example.adel.moviesapp.data.DataContract;
import com.example.adel.moviesapp.data.MoviesContentProvider;
import com.example.adel.moviesapp.data.repositories.RepositoriesInjector;

/**
 * Created by Maiam on 3/20/2017.
 */

public class AllMoviesInteractorImp implements MoviesContract.Interactor {
    Context context;
    Uri moviesUri;

    public AllMoviesInteractorImp(Context context) {
        this.context = context;
    }

    @Override
    public void fetchMoviesFromDB() {


    }

    @Override
    public void saveMovies(MovieModel movieModel) {
        ContentValues values = new ContentValues();
        for (int i = 0; i < movieModel.getResults().size(); i++) {
            ///values.put("_id",2);
            Results results = new Results();
            results = movieModel.getResults().get(i);
            values.put("_id", results.getId());

            values.put("movie_name", results.getTitle());
            values.put("desc", results.getOverview());
            values.put("rate", results.getPopularity());
            values.put("isFavorite", 1);
            Uri uri = context.getContentResolver().insert(
                    DataContract.BASE_CONTENT_URI, values);
        }

        RepositoriesInjector.inMemoryDataSavedRepository(context).saveFlag();
    }
}
