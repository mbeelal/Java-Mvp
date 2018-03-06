package com.awok.assignment.ui.detail;

import com.awok.assignment.ui.detail.interactor.MovieDetailInteractor;
import com.awok.assignment.ui.detail.interactor.MovieDetailInteractorImpl;
import com.awok.assignment.ui.detail.presenter.MovieDetailPresenter;
import com.awok.assignment.ui.detail.presenter.MovieDetailPresenterImpl;
import com.awok.assignment.ui.detail.view.DetailView;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailActivityModule {

    @Provides
    MovieDetailInteractor provideMoviesInteractor(MovieDetailInteractorImpl detailInteractor) {
        return detailInteractor;
    }

    @Provides
    MovieDetailPresenter<DetailView, MovieDetailInteractor> providMovieDetailPresenter( MovieDetailPresenterImpl<DetailView,  MovieDetailInteractor> presenter) {
        return presenter;
    }
}
