package com.awok.assignment.di.builder;

import com.awok.assignment.ui.detail.DetailActivityModule;
import com.awok.assignment.ui.detail.view.MovieDetailActivity;
import com.awok.assignment.ui.movies.MoviesListActivityModule;
import com.awok.assignment.ui.movies.view.MoviesListActivity;
import com.awok.assignment.ui.search.SearchActivityModule;
import com.awok.assignment.ui.search.view.SearchActivity;
import com.awok.assignment.ui.splash.SplashActivityModule;
import com.awok.assignment.ui.splash.view.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = MoviesListActivityModule.class)
    abstract MoviesListActivity bindMoviesActivity();

    @ContributesAndroidInjector(modules = SearchActivityModule.class)
    abstract SearchActivity bindSearchActivity();

    @ContributesAndroidInjector(modules = DetailActivityModule.class)
    abstract MovieDetailActivity bindMovieDetailActivity();
}
