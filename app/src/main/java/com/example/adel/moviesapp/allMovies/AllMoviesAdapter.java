package com.example.adel.moviesapp.allMovies;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.adel.moviesapp.Models.MovieModel;
import com.example.adel.moviesapp.MovieDetailActivity;
import com.example.adel.moviesapp.R;
import com.example.adel.moviesapp.controllers.APIController;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AllMoviesAdapter extends RecyclerView.Adapter<AllMoviesAdapter.MyViewHolder> {
    private MovieModel movieModel;
    Context context;

    public AllMoviesAdapter(MovieModel movieModel) {
        this.movieModel = movieModel;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_layout, parent, false);
        context = parent.getContext();
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.movieNameTextView.setText(movieModel.getResults().get(position).getTitle());
        holder.moviePosterImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context, MovieDetailActivity.class);
                intent.putExtra("MOVIE",movieModel.getResults().get(position));
                context.startActivity(intent);
            }
        });
        String posterLink = APIController.getInstance().getImageBaseUrl() + movieModel.getResults().get(position).getPoster_path();
        Picasso.with(context).load(posterLink).fit().into(holder.moviePosterImageView);
    }

    @Override
    public int getItemCount() {
        return movieModel.getResults().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movie_poster_imageview)
        ImageView moviePosterImageView;
        @BindView(R.id.movie_name_textview)
        TextView movieNameTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
