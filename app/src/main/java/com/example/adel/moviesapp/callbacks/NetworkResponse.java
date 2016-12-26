package com.example.adel.moviesapp.callbacks;

/**
 * Created by adelmacook on 26/12/16.
 */

public interface NetworkResponse<H> {
    void onResponse(H response);
}
