package com.awok.assignment.ui.movies.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.awok.assignment.R;
import com.awok.assignment.data.model.MoviePoster;
import com.awok.assignment.ui.base.view.BaseActivity;
import com.awok.assignment.ui.movies.interactor.MoviesInteractor;
import com.awok.assignment.ui.movies.presenter.MoviesPresenter;
import com.awok.assignment.ui.search.view.SearchActivity;
import com.awok.assignment.util.GridSpacingItemDecoration;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.List;

import javax.inject.Inject;

public class MoviesListActivity extends BaseActivity implements MovieView, NavigationView.OnNavigationItemSelectedListener {

    @Inject MoviesPresenter<MovieView, MoviesInteractor> presenter;

    @Inject GridLayoutManager gridLayoutManager;

    @Inject MoviesAdapter moviesAdapter;

    private RecyclerView moviesList;
    private MaterialSearchView searchView;
    private Toolbar toolbar;

    public static void launchActivity(Activity context) {
        context.startActivity(new Intent(context, MoviesListActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter.onAttach(this);
        presenter.getPopularMovies();

        moviesList = findViewById(R.id.movie_poster_list);
        searchView = findViewById(R.id.search_view);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Popular");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        if (searchView.isSearchOpen()){
            searchView.closeSearch();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.search) {
            startActivity(new Intent(this, SearchActivity.class));
        }
        else if (id == R.id.popular) {
            toolbar.setTitle("Popular");
            presenter.getPopularMovies();
        } else if (id == R.id.top_rated) {
            toolbar.setTitle("Top Rated");
            presenter.getTopRatedMovies();
        } else if (id == R.id.popular_kids) {
            toolbar.setTitle("Popular Kids");
            presenter.getPopularKidsMovies();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void showMoviePoster(List<MoviePoster> moviePosters) {
        moviesAdapter.setMoviePosters(moviePosters);
        if (moviesList.getAdapter() == null) {
            moviesList.setLayoutManager(gridLayoutManager);
            moviesList.setAdapter(moviesAdapter);
            int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.poster_image_margin);
            moviesList.addItemDecoration(new GridSpacingItemDecoration(2, spacingInPixels, true, 0));
        } else {
            moviesList.smoothScrollToPosition(0);
            moviesAdapter.notifyDataSetChanged();
        }
    }

}
