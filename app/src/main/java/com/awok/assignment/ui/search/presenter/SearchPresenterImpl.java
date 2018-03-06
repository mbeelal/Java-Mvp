package com.awok.assignment.ui.search.presenter;

import android.net.Uri;
import android.widget.TextView;

import com.awok.assignment.R;
import com.awok.assignment.data.model.Results;
import com.awok.assignment.ui.base.presenter.BasePresenter;
import com.awok.assignment.ui.search.interactor.SearchInteractor;
import com.awok.assignment.ui.search.view.SearchView;
import com.awok.assignment.util.SchedulerProvider;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.PublishSubject;

public class SearchPresenterImpl<V extends SearchView, I extends SearchInteractor> extends BasePresenter<V, I> implements SearchPresenter<V, I> {

    @Inject
    SearchPresenterImpl(I interactor, CompositeDisposable compositeDisposable, SchedulerProvider schedulerProvider){
        super(interactor, compositeDisposable, schedulerProvider);
    }

   /* @Override
    public void searchForQuery(String query) {
        getInteractor().searchForQuery(query)
                .compose(getSchedulerProvider().<Results>ioToMainOberverableSchedular())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (isViewAttached()) {
                            getView().showProgress();
                        }

                        getCompositeDisposable().add(disposable);

                    }
                }).doFinally(new Action() {
            @Override
            public void run() throws Exception {
                if (isViewAttached()) {
                    getView().hideProgress();
                }
            }
        }).subscribe(new Consumer<Results>() {
            @Override
            public void accept(Results results) throws Exception {
                if (isViewAttached()) {

                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });
    }*/

    public void searchViewListener(MaterialSearchView searchView) {
        Disposable disposable = fromView(searchView).debounce(500, TimeUnit.MILLISECONDS).skip(1).filter(new Predicate<String>() {
            @Override
            public boolean test(String query) throws Exception {
                return !query.isEmpty();
            }
        }).distinctUntilChanged().switchMap(new Function<String, ObservableSource<Results>>() {
            @Override
            public ObservableSource<Results> apply(String query) throws Exception {
                String encodedQuery = Uri.encode(query);
                return getInteractor().searchForQuery(encodedQuery);
            }
        }).compose(getSchedulerProvider().<Results>ioToMainOberverableSchedular()).subscribe(new Consumer<Results>() {
            @Override
            public void accept(Results results) throws Exception {

                if (isViewAttached()) {
                    getView().showSearchResults(results.getMoviePosterList());
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
            }
        });

        getCompositeDisposable().add(disposable);
    }

    private Observable<String> fromView(MaterialSearchView searchView) {

        final PublishSubject<String> subject = PublishSubject.create();

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                getView().updateTitle(text);
                subject.onNext(text);
                return true;
            }
        });

        return subject;
    }
}
