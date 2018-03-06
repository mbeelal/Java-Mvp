package com.awok.assignment.ui.splash;

import com.awok.assignment.ui.splash.interactor.SplashInteractor;
import com.awok.assignment.ui.splash.interactor.SplashInteractorImpl;
import com.awok.assignment.ui.splash.presenter.SplashPresenter;
import com.awok.assignment.ui.splash.presenter.SplashPresenterImpl;
import com.awok.assignment.ui.splash.view.SplashView;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashActivityModule {

    @Provides
    SplashInteractor provideSplashInteractor(SplashInteractorImpl splashInteractor) {
        return splashInteractor;
    }

    @Provides
    SplashPresenter<SplashView, SplashInteractor> provideSplashPresenter(SplashPresenterImpl<SplashView, SplashInteractor> presenter) {
        return presenter;
    }
}
