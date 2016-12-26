package com.example.adel.moviesapp.controllers;

import android.util.Log;

import com.example.adel.moviesapp.Models.MovieModel;
import com.example.adel.moviesapp.callbacks.NetworkResponse;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adelmacook on 26/12/16.
 */
public class APIControllerTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getInstance() throws Exception {

    }

    @Test
    public void getAllMovies() throws Exception {

        APIController.getInstance().getAllMovies(new NetworkResponse() {


            @Override
            public void onResponse(Object response) {
                assertNotNull(response);
            }
        });
    }

}