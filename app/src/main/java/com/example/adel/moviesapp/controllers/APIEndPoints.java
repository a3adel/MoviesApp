package com.example.adel.moviesapp.controllers;

import com.example.adel.moviesapp.BuildConfig;
import com.example.adel.moviesapp.Models.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by adelmacook on 26/12/16.
 */

public class APIEndPoints {
    public interface AllMoviesEndPoint{
        @GET("3/discover/movie?api_key="+ BuildConfig.APIKEY)
        Call<MovieModel>getAllMovies();
    }
}
