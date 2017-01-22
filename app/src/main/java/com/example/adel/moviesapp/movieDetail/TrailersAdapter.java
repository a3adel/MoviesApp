package com.example.adel.moviesapp.movieDetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ahmed Adel on 1/19/2017.
 */

public class TrailersAdapter extends RecyclerView.Adapter<TrailersAdapter.TrailerViewHolder> {
    @Override
    public TrailerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(TrailerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class TrailerViewHolder extends RecyclerView.ViewHolder{
        public TrailerViewHolder(View itemView) {
            super(itemView);
        }
    }
}
