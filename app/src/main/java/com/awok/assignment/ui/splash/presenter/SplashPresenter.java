package com.awok.assignment.ui.splash.presenter;

import com.awok.assignment.ui.base.presenter.MVPPresenter;
import com.awok.assignment.ui.splash.interactor.SplashInteractor;
import com.awok.assignment.ui.splash.view.SplashView;

public interface SplashPresenter<V extends SplashView, I extends SplashInteractor> extends MVPPresenter<V, I> {

}
