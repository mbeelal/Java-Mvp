package com.awok.assignment.ui.splash.presenter;

import com.awok.assignment.ui.base.presenter.BasePresenter;
import com.awok.assignment.ui.splash.interactor.SplashInteractor;
import com.awok.assignment.ui.splash.view.SplashView;
import com.awok.assignment.util.SchedulerProvider;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class SplashPresenterImpl<V extends SplashView, I extends SplashInteractor> extends BasePresenter<V, I> implements SplashPresenter<V, I> {

    @Inject
    SplashPresenterImpl(I interactor, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider){
        super(interactor, compositeDisposable, schedulerProvider);
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);

        getCompositeDisposable().add(Observable.timer(3, TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                if (isViewAttached()) {
                    getView().openMovieListActivity();
                }
            }
        }));
    }
}
