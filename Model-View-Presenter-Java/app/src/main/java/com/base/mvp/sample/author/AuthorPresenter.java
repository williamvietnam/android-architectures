package com.base.mvp.sample.author;

import com.base.mvp.core.base.BaseMvpPresenter;
import com.base.mvp.core.data.DataManager;
import com.base.mvp.core.utilities.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class AuthorPresenter<V extends AuthorContract.View>
        extends BaseMvpPresenter<V> implements AuthorContract.Presenter<V> {

    @Inject
    public AuthorPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
