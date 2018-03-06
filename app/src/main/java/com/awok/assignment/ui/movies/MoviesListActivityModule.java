package com.awok.assignment.ui.movies;

import android.support.v7.widget.GridLayoutManager;

import com.awok.assignment.data.model.MoviePoster;
import com.awok.assignment.ui.movies.interactor.MoviesInteractor;
import com.awok.assignment.ui.movies.interactor.MoviesInteractorImpl;
import com.awok.assignment.ui.movies.presenter.MoviesPresenter;
import com.awok.assignment.ui.movies.presenter.MoviesPresenterImpl;
import com.awok.assignment.ui.movies.view.MovieView;
import com.awok.assignment.ui.movies.view.MoviesAdapter;
import com.awok.assignment.ui.movies.view.MoviesListActivity;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class MoviesListActivityModule {

    @Provides
    MoviesInteractor provideMoviesInteractor(MoviesInteractorImpl moviesInteractor) {
        return moviesInteractor;
    }

    @Provides
    MoviesPresenter<MovieView, MoviesInteractor> provideMoviesPresenter(MoviesPresenterImpl<MovieView, MoviesInteractor> presenter) {
        return presenter;
    }

    @Provides
    GridLayoutManager provideGridLayoutManager(MoviesListActivity moviesListActivity) {
        return new GridLayoutManager(moviesListActivity, 2, GridLayoutManager.VERTICAL, false);
    }

    @Provides
    MoviesAdapter provideMoviesAdapter() {
        return new MoviesAdapter(new ArrayList<MoviePoster>());
    }
}
