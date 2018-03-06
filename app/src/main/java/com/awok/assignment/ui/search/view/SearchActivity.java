package com.awok.assignment.ui.search.view;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.awok.assignment.R;
import com.awok.assignment.data.model.MoviePoster;
import com.awok.assignment.ui.base.view.BaseActivity;
import com.awok.assignment.ui.movies.view.MoviesAdapter;
import com.awok.assignment.ui.search.interactor.SearchInteractor;
import com.awok.assignment.ui.search.presenter.SearchPresenter;
import com.awok.assignment.util.GridSpacingItemDecoration;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.List;

import javax.inject.Inject;

public class SearchActivity extends BaseActivity implements SearchView {

    MaterialSearchView searchView;

    @Inject
    SearchPresenter<SearchView, SearchInteractor> presenter;

    @Inject
    GridLayoutManager gridLayoutManager;

    @Inject
    MoviesAdapter moviesAdapter;

    private RecyclerView moviesList;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter.onAttach(this);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Search");
        setSupportActionBar(toolbar);

        moviesList = findViewById(R.id.movie_poster_list);
        searchView = findViewById(R.id.search_view);

        presenter.searchViewListener(searchView);

    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_search;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        searchView.setMenuItem(menuItem);

        return true;
    }

    @Override
    public void showSearchResults(List<MoviePoster> list) {
        moviesAdapter.setMoviePosters(list);
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

    @Override
    public void updateTitle(String query) {
        toolbar.setTitle(query);
    }

    @Override
    public void onBackPressed() {
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {

            presenter.onDetach();

            super.onBackPressed();
        }
    }
}
