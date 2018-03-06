package com.awok.assignment.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {

    @SerializedName("results")
    List<MoviePoster> moviePosterList;

    public List<MoviePoster> getMoviePosterList() {
        return moviePosterList;
    }
}
