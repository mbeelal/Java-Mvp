package com.awok.assignment.ui.movies.presenter;

import com.awok.assignment.data.model.Results;
import com.awok.assignment.ui.base.presenter.BasePresenter;
import com.awok.assignment.ui.movies.interactor.MoviesInteractor;
import com.awok.assignment.ui.movies.view.MovieView;
import com.awok.assignment.util.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class MoviesPresenterImpl<V extends MovieView, I extends MoviesInteractor> extends BasePresenter<V, I> implements MoviesPresenter<V, I> {

    @Inject
    MoviesPresenterImpl(I interactor, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider){
        super(interactor, compositeDisposable, schedulerProvider);
    }

    @Override
    public void getPopularMovies() {
        getInteractor().getPopularMovies().compose(getSchedulerProvider().<Results>ioToMainOberverableSchedular())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (isViewAttached()) {
                            getView().showProgress();
                        }
                        getCompositeDisposable().add(disposable);
                    }
                }).doFinally(new Action() {
            @Override
            public void run() throws Exception {
                if (isViewAttached()) {
                    getView().hideProgress();
                }
            }
        }).subscribe(new Consumer<Results>() {
            @Override
            public void accept(Results movieResults) throws Exception {
                if (isViewAttached()) {
                    getView().showMoviePoster(movieResults.getMoviePosterList());
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
            }
        });
    }

    @Override
    public void getTopRatedMovies() {
        getInteractor().getTopRatedMovies().compose(getSchedulerProvider().<Results>ioToMainOberverableSchedular())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (isViewAttached()) {
                            getView().showProgress();
                        }
                        getCompositeDisposable().add(disposable);
                    }
                }).doFinally(new Action() {
            @Override
            public void run() throws Exception {
                if (isViewAttached()) {
                    getView().hideProgress();
                }
            }
        }).subscribe(new Consumer<Results>() {
            @Override
            public void accept(Results movieResults) throws Exception {
                if (isViewAttached()) {
                    getView().showMoviePoster(movieResults.getMoviePosterList());
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
            }
        });
    }

    @Override
    public void getPopularKidsMovies() {
        getInteractor().getPopularKidsMovies().compose(getSchedulerProvider().<Results>ioToMainOberverableSchedular())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (isViewAttached()) {
                            getView().showProgress();
                        }
                        getCompositeDisposable().add(disposable);
                    }
                }).doFinally(new Action() {
            @Override
            public void run() throws Exception {
                if (isViewAttached()) {
                    getView().hideProgress();
                }
            }
        }).subscribe(new Consumer<Results>() {
            @Override
            public void accept(Results movieResults) throws Exception {
                if (isViewAttached()) {
                    getView().showMoviePoster(movieResults.getMoviePosterList());
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
