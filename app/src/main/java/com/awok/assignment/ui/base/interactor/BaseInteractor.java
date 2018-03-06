package com.awok.assignment.ui.base.interactor;

import com.awok.assignment.data.network.NetworkService;

public class BaseInteractor implements MVPInteractor {

    private NetworkService networkService;

    public BaseInteractor(NetworkService networkService) {
        this.networkService = networkService;
    }

    protected NetworkService getNetworkService() {
        return networkService;
    }
}
