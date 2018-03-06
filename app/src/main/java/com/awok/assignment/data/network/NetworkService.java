package com.awok.assignment.data.network;

import com.awok.assignment.data.model.MoviePoster;
import com.awok.assignment.data.model.Results;
import com.awok.assignment.util.AppConstants;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetworkService {

    @GET(AppConstants.POPULAR_MOVIES)
    Observable<Results> getPopularMovies();

    @GET(AppConstants.HIGHEST_RATED)
    Observable<Results> getTopRatedMovies();

    @GET(AppConstants.POPULAR_KIDS)
    Observable<Results> getPopularKidsMovies();

    @GET(AppConstants.SEARCH)
    Observable<Results> searchForResults(@Query("query") String query);

    @GET(AppConstants.MOVIE_DETAIL)
    Observable<MoviePoster> getMovieDetails(@Path("movie_id") String movieId);
}
