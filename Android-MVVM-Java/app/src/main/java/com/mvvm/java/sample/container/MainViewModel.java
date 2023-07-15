package com.mvvm.java.sample.container;

import com.mvvm.java.core.base.BaseMvvmViewModel;
import com.mvvm.java.core.data.DataManager;
import com.mvvm.java.core.utilities.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class MainViewModel extends BaseMvvmViewModel {

    @Inject
    public MainViewModel(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
