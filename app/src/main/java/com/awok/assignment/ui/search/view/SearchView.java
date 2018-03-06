package com.awok.assignment.ui.search.view;

import com.awok.assignment.data.model.MoviePoster;
import com.awok.assignment.ui.base.view.MVPView;

import java.util.List;

public interface SearchView extends MVPView {

    void showSearchResults(List<MoviePoster> list);

    void updateTitle(String query);
}
