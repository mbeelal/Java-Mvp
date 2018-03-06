package com.awok.assignment.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviePoster {

    @SerializedName("id")
    String id;

    @SerializedName("poster_path")
    String posterPath;

    @SerializedName("title")
    String title;
    @SerializedName("overview")
    String overview;

    @SerializedName("release_date")
    String releaseDate;

    @SerializedName("genres")
    List<Genre> genres;

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public String getId() {
        return id;
    }
}
