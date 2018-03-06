package com.awok.assignment.ui.detail.presenter;

import com.awok.assignment.ui.base.presenter.MVPPresenter;
import com.awok.assignment.ui.detail.interactor.MovieDetailInteractor;
import com.awok.assignment.ui.detail.view.DetailView;
import com.awok.assignment.ui.movies.view.MovieView;

public interface MovieDetailPresenter<V extends DetailView, I extends MovieDetailInteractor> extends MVPPresenter<V, I> {

    void getMovieDetails(String movieId);
}
