package com.awok.assignment.ui.movies.interactor;

import com.awok.assignment.data.model.Results;
import com.awok.assignment.ui.base.interactor.MVPInteractor;

import io.reactivex.Observable;

public interface MoviesInteractor extends MVPInteractor {

    Observable<Results> getPopularMovies();
    Observable<Results> getTopRatedMovies();
    Observable<Results> getPopularKidsMovies();
}
