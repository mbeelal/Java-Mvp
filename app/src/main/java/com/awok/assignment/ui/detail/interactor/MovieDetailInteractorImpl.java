package com.awok.assignment.ui.detail.interactor;

import com.awok.assignment.data.model.MoviePoster;
import com.awok.assignment.data.network.NetworkService;
import com.awok.assignment.ui.base.interactor.BaseInteractor;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MovieDetailInteractorImpl extends BaseInteractor implements MovieDetailInteractor {

    @Inject
    public MovieDetailInteractorImpl(NetworkService networkService) {
        super(networkService);
    }


    @Override
    public Observable<MoviePoster> getMovieDetail(String movieId) {
        return getNetworkService().getMovieDetails(movieId);
    }
}
