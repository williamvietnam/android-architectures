package com.base.mvp.sample.home;

import com.base.mvp.core.base.BaseMvpPresenter;
import com.base.mvp.core.data.DataManager;
import com.base.mvp.core.utilities.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class HomePresenter<V extends HomeContract.View>
        extends BaseMvpPresenter<V> implements HomeContract.Presenter<V> {

    @Inject
    public HomePresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
