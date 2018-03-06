package com.awok.assignment.ui.search.presenter;

import com.awok.assignment.ui.base.presenter.MVPPresenter;
import com.awok.assignment.ui.search.interactor.SearchInteractor;
import com.awok.assignment.ui.search.view.SearchView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

public interface SearchPresenter<V extends SearchView, I extends SearchInteractor> extends MVPPresenter<V, I> {

    void searchViewListener(MaterialSearchView searchView);
}
