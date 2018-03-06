package com.awok.assignment.ui.detail.view;

import com.awok.assignment.data.model.MoviePoster;
import com.awok.assignment.ui.base.view.MVPView;

public interface DetailView extends MVPView{

    void showMovieDetail(MoviePoster moviePoster);
}
