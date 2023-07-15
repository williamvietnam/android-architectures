package com.base.mvp.sample.main;

import com.base.mvp.core.base.BaseMvpPresenter;
import com.base.mvp.core.data.DataManager;
import com.base.mvp.core.utilities.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

/**
 * Author: William Giang Nguyen | 25/06/2022
 * */
public class MainPresenter<V extends MainContract.View>
        extends BaseMvpPresenter<V> implements MainContract.Presenter<V> {

    @Inject
    public MainPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
