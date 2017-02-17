package com.example.adel.moviesapp.allMovies;

import android.app.Fragment;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.adel.moviesapp.Models.MovieModel;
import com.example.adel.moviesapp.R;
import com.example.adel.moviesapp.data.repositories.RepositoriesInjector;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MoviesFragment extends Fragment implements MoviesContract.View {
    @BindView(R.id.movies_recycleview)
    RecyclerView moviesRecycler;
    MoviesContract.Presenter moviesPresenter;
    Unbinder unbinder;
    AllMoviesAdapter allMoviesAdapter;

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
        moviesRecycler.setLayoutManager(new GridLayoutManager(container.getContext(), 2));
        moviesRecycler.addItemDecoration(new DividerItemDecoration(container.getContext(), DividerItemDecoration.HORIZONTAL));
        moviesPresenter.fetchMovies(RepositoriesInjector.inMemoryDataSavedRepository(getActivity()).isDataSaved());
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_movie_detail, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.top_rated) {
            moviesPresenter.fetchTopRated();
        } else if (id == R.id.discover_menu) {

        } else if (id == R.id.popular_menu_item) {
            moviesPresenter.fetchPopular();
        }
        return true;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void moviesFetched(MovieModel movieModel) {
        if (allMoviesAdapter == null)
            allMoviesAdapter = new AllMoviesAdapter(movieModel);
        else
            allMoviesAdapter.setData(movieModel);
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
