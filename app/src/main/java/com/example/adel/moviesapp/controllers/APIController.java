package com.example.adel.moviesapp.controllers;

import android.util.Log;

import com.example.adel.moviesapp.Models.MovieModel;
import com.example.adel.moviesapp.callbacks.NetworkResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIController {
    static APIController apiController;
    Retrofit retrofitObject;
    final String baseUrl = "https://api.themoviedb.org";
    final String imageBaseURL = "http://image.tmdb.org/t/p/w185";

    private APIController() {
        retrofitObject = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public String getImageBaseUrl() {
        return imageBaseURL;
    }

    public static APIController getInstance() {
        if (apiController == null)
            return new APIController();
        else return apiController;
    }

    public void getAllMovies(final NetworkResponse<MovieModel> networkResponse) {
        APIEndPoints.AllMoviesEndPoint allMoviesEndPoint = retrofitObject.create(APIEndPoints.AllMoviesEndPoint.class);
        try {
            Call<MovieModel> call = allMoviesEndPoint.getAllMovies();
            call.enqueue(new Callback<MovieModel>() {
                @Override
                public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                    Log.d("ID", response.body().getResults().get(0).getTitle());
                    networkResponse.onResponse(response.body());
                }


                @Override
                public void onFailure(Call<MovieModel> call, Throwable t) {
                    Log.d("ERROR", t.getLocalizedMessage());
                }
            });
        } catch (Exception e) {

        }
    }

    public void getPopularMovies(final NetworkResponse<MovieModel> networkResponse) {
        APIEndPoints.PopularMovies popularMoviesEndPoint = retrofitObject.create(APIEndPoints.PopularMovies.class);
        try {
            Call<MovieModel> call = popularMoviesEndPoint.getPopular();
            call.enqueue(new Callback<MovieModel>() {
                @Override
                public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                    networkResponse.onResponse(response.body());
                }

                @Override
                public void onFailure(Call<MovieModel> call, Throwable t) {

                }
            });
        } catch (Exception e) {
        }
    }

    public void getTopRated(final NetworkResponse<MovieModel> networkResponse) {
        APIEndPoints.TopRatedMovies topRatedMovies = retrofitObject.create(APIEndPoints.TopRatedMovies.class);
        try {
            Call<MovieModel> call = topRatedMovies.getTopRatedMovies();
            call.enqueue(new Callback<MovieModel>() {
                @Override
                public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                    networkResponse.onResponse(response.body());
                }

                @Override
                public void onFailure(Call<MovieModel> call, Throwable t) {

                }
            });
        } catch (Exception e) {

        }
    }
}
