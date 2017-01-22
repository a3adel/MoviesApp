package com.example.adel.moviesapp.Models;

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

    int id;
    ArrayList<TrailerModel>trailers;
}
