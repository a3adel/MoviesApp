package com.example.adel.moviesapp.allMovies;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.adel.moviesapp.Models.MovieModel;
import com.example.adel.moviesapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MoviesFragment extends Fragment implements MoviesContract.View {
    @BindView(R.id.movies_recycleview)
    RecyclerView moviesRecycler;
    MoviesContract.Presenter moviesPresenter;
    Unbinder unbinder;

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_all_movies_layout, container);
        View view = inflater.inflate(R.layout.fragment_all_movies_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        moviesRecycler.setLayoutManager(new GridLayoutManager(container.getContext(),2));
        moviesPresenter.fetchMovies();
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void moviesFetched(MovieModel movieModel) {
        Toast.makeText(getActivity(), movieModel.getResults().get(0).getTitle(), Toast.LENGTH_SHORT).show();
        AllMoviesAdapter allMoviesAdapter=new AllMoviesAdapter(movieModel);
        moviesRecycler.setAdapter(allMoviesAdapter);
        //allMoviesAdapter.notifyDataSetChanged();
    }


    @Override
    public void onResume() {
        super.onResume();
        moviesPresenter.start();
    }

    @Override
    public void setPresenter(MoviesContract.Presenter presenter) {
        moviesPresenter = presenter;
    }
}
