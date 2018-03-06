package com.awok.assignment.ui.detail.interactor;

import com.awok.assignment.data.model.MoviePoster;
import com.awok.assignment.data.model.Results;
import com.awok.assignment.ui.base.interactor.MVPInteractor;

import io.reactivex.Observable;

public interface MovieDetailInteractor extends MVPInteractor {

    Observable<MoviePoster> getMovieDetail(String movieId);
}
