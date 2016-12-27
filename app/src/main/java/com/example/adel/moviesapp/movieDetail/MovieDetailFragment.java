package com.example.adel.moviesapp.movieDetail;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adel.moviesapp.Models.Results;
import com.example.adel.moviesapp.MovieDetailActivity;
import com.example.adel.moviesapp.R;
import com.example.adel.moviesapp.controllers.APIController;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by adelmacook on 27/12/16.
 */

public class MovieDetailFragment extends Fragment {
    Results movie;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolBar;
    @BindView(R.id.overview_textView)
    TextView overviewTextView;
    Drawable drawable;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        movie = (Results) bundle.getSerializable(MovieDetailActivity.MOVIE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        Toast.makeText(getActivity(), movie.getTitle()
                , Toast.LENGTH_SHORT).show();
        ButterKnife.bind(this,view);
        toolBar.setTitle(movie.getTitle());
        overviewTextView.setText(movie.getOverview());
        String imagePath= APIController.getInstance().getImageBaseUrl()+movie.getPoster_path();
        Picasso.with(container.getContext()).load(imagePath).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                drawable=new BitmapDrawable(bitmap);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    toolBar.setBackground(drawable);
                }
                else
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
}
