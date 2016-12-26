package com.example.adel.moviesapp.Models;

import java.util.ArrayList;
import java.util.StringTokenizer;


public class MovieModel {
    private int page;

    public ArrayList<Results> getResults() {
        return results;
    }

    public void setResults(ArrayList<Results> results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    private ArrayList<Results> results;

}
