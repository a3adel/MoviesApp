package com.example.adel.moviesapp.movieDetail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adel.moviesapp.Models.TrailerResponseModel;
import com.example.adel.moviesapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ahmed Adel on 1/19/2017.
 */

public class TrailersAdapter extends RecyclerView.Adapter<TrailersAdapter.TrailerViewHolder> {
    TrailerResponseModel trailerResponseModel;

    public TrailersAdapter(TrailerResponseModel trailerResponseModel) {
        this.trailerResponseModel = trailerResponseModel;
    }

    @Override
    public TrailerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trailer_layout, parent, false);
        return new TrailerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrailerViewHolder holder, int position) {
        holder.trailerName.setText(trailerResponseModel.getTrailers().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return trailerResponseModel.getTrailers().size();
    }
    public void updateAdapter(TrailerResponseModel trailerResponseModel){
        this.trailerResponseModel=trailerResponseModel;
        notifyDataSetChanged();
    }
    public class TrailerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movie_trailer_iv)
        ImageView trailerImage;
        @BindView(R.id.trailer_name_tv)
        TextView trailerName;

        public TrailerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
