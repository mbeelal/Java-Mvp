package com.awok.assignment.ui.base.presenter;

import com.awok.assignment.ui.base.interactor.MVPInteractor;
import com.awok.assignment.ui.base.view.MVPView;
import com.awok.assignment.util.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<V extends MVPView, I extends MVPInteractor>  implements MVPPresenter<V, I>{

    private I mvpInteractor;
    private V view = null;

    private final SchedulerProvider schedulerProvider;
    private final CompositeDisposable compositeDisposable;

    public  BasePresenter(I interactor, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider) {
        mvpInteractor = interactor;
        this.schedulerProvider = schedulerProvider;
        this.compositeDisposable = compositeDisposable;
    }

    public boolean isViewAttached() {
       return  view != null;
    }

    @Override
    public void onAttach(V view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
        this.mvpInteractor = null;
        this.compositeDisposable.dispose();
    }

    @Override
    public V getView() {
        return view;
    }

    public I getInteractor() {
        return mvpInteractor;
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public SchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }
}