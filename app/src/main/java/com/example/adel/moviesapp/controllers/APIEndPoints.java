package com.example.adel.moviesapp.controllers;

import com.example.adel.moviesapp.BuildConfig;
import com.example.adel.moviesapp.Models.MovieModel;
import com.example.adel.moviesapp.Models.TrailerResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public class APIEndPoints {
    public interface AllMoviesEndPoint {
        @GET("3/discover/movie?api_key=" + BuildConfig.APIKEY)
        Call<MovieModel> getAllMovies();
    }

    public interface TopRatedMovies {
        @GET("3/movie/top_rated?api_key=" + BuildConfig.APIKEY)
        Call<MovieModel> getTopRatedMovies();
    }

    public interface PopularMovies {
        @GET("3/movie/popular?api_key=" + BuildConfig.APIKEY)
        Call<MovieModel> getPopular();
    }

    public interface MovieTrailer {
        @GET("3/movie/{id}/videos?api_key=" + BuildConfig.APIKEY)
        Call<TrailerResponseModel> getMovieTrailer(@Path("id") int movieId);
    }
}
