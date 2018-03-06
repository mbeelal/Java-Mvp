package com.awok.assignment.ui.base.presenter;

import com.awok.assignment.ui.base.interactor.MVPInteractor;
import com.awok.assignment.ui.base.view.MVPView;

public interface MVPPresenter<V extends MVPView, I extends MVPInteractor> {

    void onAttach(V view);

    void  onDetach();

    V getView();
}