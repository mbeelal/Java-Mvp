package com.awok.assignment.ui.search.interactor;

import com.awok.assignment.data.model.Results;
import com.awok.assignment.ui.base.interactor.MVPInteractor;

import io.reactivex.Observable;

public interface SearchInteractor extends MVPInteractor {

    Observable<Results> searchForQuery(String query);
}
