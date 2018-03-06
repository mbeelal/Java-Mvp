package com.awok.assignment.ui.search;

import android.support.v7.widget.GridLayoutManager;

import com.awok.assignment.data.model.MoviePoster;
import com.awok.assignment.ui.movies.view.MoviesAdapter;
import com.awok.assignment.ui.search.interactor.SearchInteractor;
import com.awok.assignment.ui.search.interactor.SearchInteractorImpl;
import com.awok.assignment.ui.search.presenter.SearchPresenter;
import com.awok.assignment.ui.search.presenter.SearchPresenterImpl;
import com.awok.assignment.ui.search.view.SearchActivity;
import com.awok.assignment.ui.search.view.SearchView;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchActivityModule {

    @Provides
    SearchInteractor provideSearchInteractor(SearchInteractorImpl searchInteractor) {
        return searchInteractor;
    }

    @Provides
    SearchPresenter<SearchView, SearchInteractor> provideSearchPresenter(SearchPresenterImpl<SearchView, SearchInteractor> presenter) {
        return presenter;
    }

    @Provides
    GridLayoutManager provideGridLayoutManager(SearchActivity searchListActivity) {
        return new GridLayoutManager(searchListActivity, 2, GridLayoutManager.VERTICAL, false);
    }

    @Provides
    MoviesAdapter provideMoviesAdapter() {
        return new MoviesAdapter(new ArrayList<MoviePoster>());
    }
}
