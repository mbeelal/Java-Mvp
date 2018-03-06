package com.awok.assignment.ui.movies.presenter;

import com.awok.assignment.ui.base.presenter.MVPPresenter;
import com.awok.assignment.ui.movies.interactor.MoviesInteractor;
import com.awok.assignment.ui.movies.view.MovieView;

public interface MoviesPresenter<V extends MovieView, I extends MoviesInteractor> extends MVPPresenter<V, I> {

    void getPopularMovies();

    void getTopRatedMovies();

    void getPopularKidsMovies();
}
