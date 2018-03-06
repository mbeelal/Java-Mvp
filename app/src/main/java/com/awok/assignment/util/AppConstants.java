package com.awok.assignment.util;

public interface AppConstants {

    //"https://api.themoviedb.org/3/discover/movie/?certification_country=US&certification=R&sort_by=vote_average.desc&api_key=41f4d02979140db673686c12e6ccfe10"
    //"https://api.themoviedb.org/3/search/multi?language=en-US&page=1&include_adult=false&api_key=41f4d02979140db673686c12e6ccfe10&query=300"

    String BASE_URL = "https://api.themoviedb.org/3/";
    String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500";

    String API_KEY = "41f4d02979140db673686c12e6ccfe10";

    String POPULAR_MOVIES = "discover/movie?sort_by=popularity.desc&api_key=" + API_KEY;

    String HIGHEST_RATED = "discover/movie/?certification_country=US&certification=R&sort_by=vote_average.desc&api_key=" + API_KEY;

    String POPULAR_KIDS = "discover/movie?certification_country=US&certification.lte=G&sort_by=popularity.desc&api_key=" + API_KEY;

    String QUERY = "query";

    String SEARCH = "search/multi?language=en-US&page=1&include_adult=false&api_key=" + API_KEY;

    String MOVIE_DETAIL = "movie/{movie_id}?language=en-US&api_key=" +  API_KEY;
}
