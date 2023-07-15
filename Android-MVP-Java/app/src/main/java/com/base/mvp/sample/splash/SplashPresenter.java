package com.base.mvp.sample.splash;

import com.base.mvp.core.base.BaseMvpPresenter;
import com.base.mvp.core.data.DataManager;
import com.base.mvp.core.utilities.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class SplashPresenter<V extends SplashContract.View> extends BaseMvpPresenter<V> implements SplashContract.Presenter<V> {

    @Inject
    public SplashPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
