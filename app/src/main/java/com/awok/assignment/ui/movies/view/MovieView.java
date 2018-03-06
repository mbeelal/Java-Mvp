package com.awok.assignment.ui.movies.view;

import com.awok.assignment.data.model.MoviePoster;
import com.awok.assignment.ui.base.view.MVPView;

import java.util.List;

public interface MovieView extends MVPView {

    void showMoviePoster(List<MoviePoster> moviePosters);
}
