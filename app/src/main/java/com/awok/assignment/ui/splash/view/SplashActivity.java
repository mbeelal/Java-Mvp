package com.awok.assignment.ui.splash.view;

import android.os.Bundle;

import com.awok.assignment.ui.movies.view.MoviesListActivity;
import com.awok.assignment.R;
import com.awok.assignment.ui.base.view.BaseActivity;
import com.awok.assignment.ui.splash.interactor.SplashInteractor;
import com.awok.assignment.ui.splash.presenter.SplashPresenter;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashView {

    @Inject
    SplashPresenter<SplashView, SplashInteractor> splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        splashPresenter.onAttach(this);
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_splash;
    }

    @Override
    public void openMovieListActivity() {
        MoviesListActivity.launchActivity(this);
        finish();
    }

    @Override
    protected void onDestroy() {
        splashPresenter.onDetach();

        super.onDestroy();
    }
}
