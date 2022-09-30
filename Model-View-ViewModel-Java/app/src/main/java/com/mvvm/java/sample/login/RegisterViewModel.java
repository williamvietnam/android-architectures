package com.mvvm.java.sample.login;

import com.mvvm.java.core.base.BaseMvvmViewModel;
import com.mvvm.java.core.data.DataManager;
import com.mvvm.java.core.utilities.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class RegisterViewModel extends BaseMvvmViewModel {

    @Inject
    public RegisterViewModel(DataManager dataManager,
                             SchedulerProvider schedulerProvider,
                             CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


}