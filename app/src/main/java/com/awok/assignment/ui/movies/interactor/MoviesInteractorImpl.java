package com.awok.assignment.ui.movies.interactor;

import com.awok.assignment.data.model.Results;
import com.awok.assignment.data.network.NetworkService;
import com.awok.assignment.ui.base.interactor.BaseInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MoviesInteractorImpl extends BaseInteractor implements MoviesInteractor {

    @Inject
    public MoviesInteractorImpl(NetworkService networkService) {
        super(networkService);
    }


    @Override
    public Observable<Results> getPopularMovies() {
        return getNetworkService().getPopularMovies();
    }

    @Override
    public Observable<Results> getTopRatedMovies() {
        return getNetworkService().getTopRatedMovies();
    }

    @Override
    public Observable<Results> getPopularKidsMovies() {
        return getNetworkService().getPopularKidsMovies();
    }
}
