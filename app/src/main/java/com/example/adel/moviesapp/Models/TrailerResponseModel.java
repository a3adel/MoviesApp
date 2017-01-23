package com.example.adel.moviesapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Ahmed Adel on 1/19/2017.
 */

public class TrailerResponseModel {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<TrailerModel> getTrailers() {
        return trailers;
    }

    public void setTrailers(ArrayList<TrailerModel> trailers) {
        this.trailers = trailers;
    }
    @SerializedName("id")
    int id;
    @SerializedName("results")
    ArrayList<TrailerModel>trailers;
}
