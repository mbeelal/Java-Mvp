package com.awok.assignment.ui.search.interactor;

import com.awok.assignment.data.model.Results;
import com.awok.assignment.data.network.NetworkService;
import com.awok.assignment.ui.base.interactor.BaseInteractor;

import javax.inject.Inject;

import io.reactivex.Observable;

public class SearchInteractorImpl extends BaseInteractor implements SearchInteractor {

    @Inject
    public SearchInteractorImpl(NetworkService networkService) {
        super(networkService);
    }

    @Override
    public Observable<Results> searchForQuery(String query) {
        return getNetworkService().searchForResults(query);
    }
}
