package com.example.adel.moviesapp.movieDetail;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.adel.moviesapp.Models.Results;
import com.example.adel.moviesapp.Models.TrailerResponseModel;
import com.example.adel.moviesapp.R;
import com.example.adel.moviesapp.controllers.APIController;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by adelmacook on 27/12/16.
 */

public class MovieDetailFragment extends Fragment implements MovieDetailContract.MovieDetailView {
    Results movie;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolBar;
    @BindView(R.id.overview_textView)
    TextView overviewTextView;
    @BindView(R.id.movie_release_date_textView)
    TextView releaseDateTextView;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.trailers_recyclerView)
    RecyclerView trailersRecyclerView;
    Drawable drawable;
    MovieDetailContract.MovieDetailPresenter movieDetailPresenter;
    int movieId;
    final static String MOVIE = "_movie";
    TrailersAdapter trailersAdapter;

    public static MovieDetailFragment getInstance(Results movie) {
        MovieDetailFragment movieDetailFragment = new MovieDetailFragment();
        // Results mMovie=movie;
        Bundle bundle = new Bundle();
        bundle.putSerializable(MOVIE, movie);
        movieDetailFragment.setArguments(bundle);
        return movieDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        movie = (Results) bundle.getSerializable(MOVIE);
        Log.i("IID", movie.getId() + "");
        Log.i("name", movie.getTitle()
                + "");
        movieId = movie.getId();
        movieDetailPresenter.fetchTrailer(movieId);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);

        ButterKnife.bind(this, view);


        toolBar.setTitle(movie.getTitle());
        overviewTextView.setText(movie.getOverview());
        String imagePath = APIController.getInstance().getImageBaseUrl() + movie.getPoster_path();
        releaseDateTextView.setText(movie.getRelease_date());
        float avg = (float) movie.getVote_average() / 10;
        avg *= 5;
        ratingBar.setRating(avg);
        ratingBar.setClickable(false);
        Picasso.with(container.getContext()).load(imagePath).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                drawable = new BitmapDrawable(bitmap);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    toolBar.setBackground(drawable);
                } else
                    toolBar.setBackgroundDrawable(drawable);

            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });
        return view;
    }

    @Override
    public void setPresenter(MovieDetailContract.MovieDetailPresenter presenter) {
        movieDetailPresenter = presenter;

    }

    @Override
    public void onTrailersFetched(TrailerResponseModel trailerResponseModel) {
        Log.d("RES",trailerResponseModel.getId()+"\t"+trailerResponseModel.getTrailers().size());
        trailersAdapter = new TrailersAdapter(trailerResponseModel);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        trailersRecyclerView.setLayoutManager(linearLayoutManager);
        trailersRecyclerView.setAdapter(trailersAdapter);//  trailersAdapter.set
    }
}
