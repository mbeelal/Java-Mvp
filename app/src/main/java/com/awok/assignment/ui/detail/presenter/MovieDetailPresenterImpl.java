package com.awok.assignment.ui.detail.presenter;

import com.awok.assignment.data.model.MoviePoster;
import com.awok.assignment.data.model.Results;
import com.awok.assignment.ui.base.presenter.BasePresenter;
import com.awok.assignment.ui.detail.interactor.MovieDetailInteractor;
import com.awok.assignment.ui.detail.view.DetailView;
import com.awok.assignment.ui.movies.view.MovieView;
import com.awok.assignment.util.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class MovieDetailPresenterImpl<V extends DetailView, I extends MovieDetailInteractor> extends BasePresenter<V, I> implements MovieDetailPresenter<V, I> {

    @Inject
    MovieDetailPresenterImpl(I interactor, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        super(interactor, compositeDisposable, schedulerProvider);
    }

    @Override
    public void getMovieDetails(String movieId) {
        getInteractor().getMovieDetail(movieId).compose(getSchedulerProvider().<MoviePoster>ioToMainOberverableSchedular())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        getView().showProgress();
                        getCompositeDisposable().add(disposable);
                    }
                }).doFinally(new Action() {
            @Override
            public void run() throws Exception {
                getView().hideProgress();
            }
        }).subscribe(new Consumer<MoviePoster>() {
            @Override
            public void accept(MoviePoster moviePoster) throws Exception {
                if (isViewAttached()) {
                    getView().showMovieDetail(moviePoster);
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
            }
        });
    }
}
