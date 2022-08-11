package com.base.mvp.sample.login;

import com.base.mvp.core.base.BaseMvpPresenter;
import com.base.mvp.core.data.DataManager;
import com.base.mvp.core.utilities.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class LoginPresenter<V extends LoginContract.View>
        extends BaseMvpPresenter<V> implements LoginContract.Presenter<V> {

    @Inject
    public LoginPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
